
## 🔹 Step‑by‑Step Process with Commands

1. **Project folder में जाएँ**
   ```bash
   cd C:\Users\ak14d\Desktop\SpringBatch
   ```

2. **Git initialize करें**
   ```bash
   git init
   ```

3. **GitHub पर repository create करें**
    - GitHub → New Repository → Name: `spring-batch-demo` → Create.

4. **Remote origin add करें**
   ```bash
   git remote add origin https://github.com/kumarankit141293-max/spring-batch-demo.git
   ```

5. **Git config setup करें (पहली बार)**
   ```bash
   git config --global user.name "Ankit Kumar"
   git config --global user.email "kumaranakit141293@gmail.com"
   ```

6. **Files stage करें**
   ```bash
   git add .
   ```

7. **पहला commit करें**
   ```bash
   git commit -m "Initial commit"
   ```

8. **Branch को main में rename करें**
   ```bash
   git branch -M main
   ```

9. **Remote verify करें**
   ```bash
   git remote -v
   ```

10. **Push करें GitHub पर**
    ```bash
    git push -u origin main
    ```

---

## ✅ Summary
- पहले GitHub पर repository बनानी ज़रूरी है।
- फिर local repo initialize → remote add → config set → commit → branch rename → push।
- इसके बाद आपका project GitHub repository में दिखाई देगा।


आपने सही push कर लिया, लेकिन GitHub पर **push करने से सीधे PR (Pull Request) नहीं बनता**। Push सिर्फ़ code को remote branch पर भेजता है। **PR बनाने के लिए आपको GitHub UI या GitHub CLI का इस्तेमाल करना पड़ता है।**

---

## 🔹 Flow: Push → Branch → Pull Request

1. **Default branch (main) पर code push करने से PR नहीं बनेगा।**
    - अगर आप सीधे `main` पर push करते हैं, तो changes उसी branch में merge हो जाते हैं।

2. **PR बनाने के लिए अलग branch बनाइए:**
   ```bash
   git checkout -b feature/spring-batch-demo
   git add .
   git commit -m "Added Spring Batch demo project"
   git push origin feature/spring-batch-demo
   ```

3. **GitHub पर जाएँ:**
    - Repo page पर आपको notification दिखेगा: *“Compare & pull request”*.
    - उस पर click करके PR create करें।

4. **PR में details लिखें:**
    - Title: क्या change किया है।
    - Description: क्यों change किया है।
    - Reviewer assign करें (optional)।

---

## 🔹 Share करने का तरीका
- PR बन जाने के बाद GitHub आपको एक URL देगा, जैसे:
  ```
  https://github.com/kumarankit141293-max/spring-batch-demo/pull/1
  ```
- आप यह URL किसी को भी share कर सकते हैं।
- Reviewer उस PR को देख सकता है, comment कर सकता है, और approve करके merge कर सकता है।

---

## ✅ Summary
- Push → सिर्फ़ code remote branch पर जाता है।
- PR बनाने के लिए **new branch push करें** और फिर GitHub पर PR open करें।
- PR का link share करके आप दूसरों को review के लिए invite कर सकते हैं।

---

क्या आप चाहेंगे कि मैं आपके लिए एक **step‑by‑step diagram** बनाऊँ जिसमें दिखाऊँ कि **local branch → push → GitHub PR → share link** का पूरा flow कैसे होता है?

या फिर मैं आपको detail में Create Pull Request और Share PR link समझा सकता हूँ।