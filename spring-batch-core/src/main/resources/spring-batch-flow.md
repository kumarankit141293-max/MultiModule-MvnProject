
## 2. Flow Diagram
**Reader → Processor → Writer → DB**

- **Reader**: FlatFileItemReader (CSV से data पढ़ता है)
- **Processor**: Transformation logic (जैसे uppercase)
- **Writer**: JpaItemWriter (DB में persist करता है)
- **JobConfig**: Step और Job orchestration

## 3. Rules
- Reader हमेशा source से data उठाएगा (CSV/DB/API)
- Processor में business logic रहेगा
- Writer DB में insert/update करेगा
- JobConfig में chunk size और transact
- endion manager define होगा

## 4. Example Code

### Reader
```java
@Bean
public FlatFileItemReader<Student> csvReader() {
    FlatFileItemReader<Student> reader = new FlatFileItemReader<>();
    reader.setResource(new ClassPathResource("users_100.csv"));
    reader.setLinesToSkip(1);
    reader.setLineMapper(new DefaultLineMapper<Student>() {{
        setLineTokenizer(new DelimitedLineTokenizer() {{
            setNames("name", "email", "age");
        }});
        setFieldSetMapper(new BeanWrapperFieldSetMapper<Student>() {{
            setTargetType(Student.class);
        }});
    }});
    return reader;
}


1. JdbcBatchItemWriter
यह तब use होता है जब तुम्हें DB → DB data transfer करना हो।

Example: एक table से data पढ़कर दूसरे table में insert करना।

यह direct SQL INSERT/UPDATE statements execute करता है, Hibernate/JPA का overhead नहीं होता।

Best for bulk inserts/updates क्योंकि यह JDBC batch operations करता है → बहुत fast होता है।
2. JpaItemWriter
यह तब use होता है जब तुम्हें external source → DB data persist करना हो (जैसे CSV → DB, JSON → DB)।

यह Hibernate/JPA का EntityManager.merge() use करता है।

Entity lifecycle manage करता है (persist, merge, update)।

लेकिन अगर तुम DB से ही पढ़कर उसी DB में लिख रहे हो, तो merge() conflict दे सकता है (जैसा तुम्हें OptimisticLockException मिला)।
CSV → DB → use JpaItemWriter (Hibernate handle करेगा)।

DB → DB → use JdbcBatchItemWriter (direct SQL, fast, no merge conflict)।

API → DB → दोनों चल सकते हैं, लेकिन JPA ज्यादा natural है।
