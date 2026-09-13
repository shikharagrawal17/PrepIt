# PrepIt

**PrepIt** is an Android app that helps students prepare for company interviews. Browse company profiles stored in **Firebase Realtime Database**, read placement stats and interview rounds, and pull **community-uploaded interview questions** from a REST backend. Users can sign in, explore companies, and contribute new questions.

Built as a native **Java** app with **Material Design**, **MVVM-style** networking, and **Firebase Authentication**.

---

## Features

- **Email/password auth** — Sign up and log in with Firebase Auth; session persists across launches.
- **Company directory** — Grid of companies (logo + name) synced live from Firebase (`Company` node).
- **Company detail** — Placements, interview rounds, and salary info; tap **interview questions** to open the question list.
- **Question bank** — Fetches questions per company from REST API (`GET question/{company}`).
- **Community uploads** — Authenticated users can submit question text + link (`PUT upload`) for companies like Google, Microsoft, Amazon, and others.
- **Profile** — Username and profile image (Glide) from Firebase `Users/{uid}`.
- **Polished UI** — Lottie, RecyclerView animators, fullscreen splash, CardView layouts.

---

## Architecture

```text
┌─────────────────────────────────────────────────────────────┐
│                        Android App                          │
├─────────────────────────────────────────────────────────────┤
│  UI: Activities / Fragments                                 │
│    Splash → Login / SignUp → MainActivity (MainFragment)    │
│    descFragment → ApiActivity (questions)                   │
│    QuestionUploadActivity                                   │
├─────────────────────────────────────────────────────────────┤
│  ViewModel: ApiActivityViewModel                            │
│  Repository: Repository (Retrofit + LiveData)               │
├─────────────────────────────────────────────────────────────┤
│  Firebase Auth + Realtime DB (users, companies)             │
│  Retrofit → https://rppoop-api.herokuapp.com/               │
└─────────────────────────────────────────────────────────────┘
```

| Component | Technology |
|-----------|------------|
| Language | Java |
| Min SDK | 28 |
| Target SDK | 32 |
| UI | AndroidX, Material, Fragments |
| Auth & DB | Firebase Auth, Firebase Realtime Database |
| HTTP | Retrofit 2 + Gson |
| Images | Glide, CircleImageView |
| Lists | FirebaseUI `FirebaseRecyclerAdapter`, custom `QuestionAdapter` |

---

## Screens & flow

1. **Splash** — Entry screen.
2. **Login / Sign up** — Firebase email/password; new users get a `Users` record (`username`, `ProfilePic`).
3. **Home** — Toolbar + company grid (`MainFragment`).
4. **Company detail** (`descFragment`) — Stats and **View questions**.
5. **Questions** (`ApiActivity`) — RecyclerView of `QuestionModel` items from API.
6. **Upload** (menu) — Pick company, enter question + link; `Repository.uploadQuestion`.

---

## Backend API

Base URL (configured in `RetrofitInstance`):

`https://rppoop-api.herokuapp.com/`

| Method | Endpoint | Purpose |
|--------|----------|---------|
| `GET` | `question/{company}` | List questions for a company |
| `PUT` | `upload` | JSON body: `company`, `question`, `questionLink` |

The repo also contains a **Procfile** (`web: gunicorn app:main`) and empty `main.py` / `requirements.txt` for a possible Python backend deployment—the live app points at the Heroku host above.

---

## Firebase setup

1. Create a Firebase project and enable **Authentication** (Email/Password) and **Realtime Database**.
2. Replace `app/google-services.json` with your own (do not commit production secrets to a public fork).
3. Structure (as used in code):
   - `Users/{uid}` — `id`, `username`, `ProfilePic`
   - `Company/{id}` — `name`, `logo`, `placements`, `averageSalary`, `rounds`

Apply appropriate **Firebase security rules** before production use.

---

## Getting started

### Prerequisites

- Android Studio (Arctic Fox or newer recommended)
- JDK 8+
- Android SDK 32

### Run locally

```bash
git clone https://github.com/shikharagrawal17/PrepIt.git
cd PrepIt
```

1. Open the project in Android Studio.
2. Add your `google-services.json` under `app/`.
3. Sync Gradle and run on an emulator or device (API 28+).

```bash
./gradlew assembleDebug
```

---

## Project structure

```
PrepIt/
├── app/
│   ├── src/main/java/com/example/rppoop/
│   │   ├── LoginActivity.java, SignUpActivity.java
│   │   ├── MainActivity.java, MainFragment.java, descFragment.java
│   │   ├── ApiActivity.java, QuestionUploadActivity.java
│   │   ├── Repository.java
│   │   ├── service/          # Retrofit interfaces
│   │   ├── viewmodel/        # ApiActivityViewModel
│   │   ├── models/           # QuestionModel, ResultsModel
│   │   └── adapters/
│   └── src/main/res/         # Layouts, menus, assets (Lottie JSON)
├── build.gradle
├── settings.gradle
├── Procfile
└── requirements.txt
```

---

## Supported companies (upload spinner)

Google, Apple, Adobe, Arcesium, DE Shaw, Credit Suisse, TCS, Tech Mahindra, Microsoft, UBS, Amazon, BYJU'S, Nvidia — extend the list in `QuestionUploadActivity` as needed.

---

## Security notes

- Rotate or remove committed Firebase config if the repo is public.
- The bundled `google-services.json` is for development; use environment-specific configs for release builds.
- Validate and sanitize uploads on the server; the client trusts the REST API response.

---

## Author

**Shikhar Agrawal** — [GitHub](https://github.com/shikharagrawal17)

---

## License

No license file is present. Add one if you plan to open-source or share the project widely.
