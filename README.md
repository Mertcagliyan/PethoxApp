# Pethox: Social Network & Pet Matching App

![Language](https://img.shields.io/badge/language-Java-orange.svg)
![Platform](https://img.shields.io/badge/platform-Android-green.svg)
![Architecture](https://img.shields.io/badge/architecture-MVVM%20%7C%20DataBinding-blue.svg)
![Backend](https://img.shields.io/badge/backend-Firebase-yellow.svg)
![License](https://img.shields.io/badge/license-GPLv3-red.svg)

**Pethox** is a comprehensive native Android application designed to build a community for pet owners. It combines social media features with a specialized "Pet Matching" system, **a dedicated "Pet Adoption" platform**, real-time messaging, and a tiered monetization model using Google AdMob and Premium subscriptions.

> **⚠️ Status:** This project is **archived**. It serves as a showcase of native Android development capabilities, demonstrating complex UI handling, NoSQL database integration, and business logic implementation.

## 📱 Key Features

### 🐾 Social, Matching & Adoption Ecosystem
* **Pet Partner Matching:** A dedicated directory (`MatchingPartnerFragment`) allowing users to find playmates or partners for their pets based on species, breed, and location. Data is modeled via `MatchingPet` class.
* **Pet Adoption Platform:** A centralized interface designed to facilitate ethical rehoming. It connects shelters and individual owners with potential adopters, allowing users to browse profiles of pets looking for a forever home.
* **Dynamic Social Feed:** Real-time post stream ordered by date, fetching `Post` objects efficiently from **Cloud Firestore** (`HomeFragment`).
* **Real-Time Messaging:** Instant chat system supporting image sharing (`messageActivity`) and user search functionality with live filtering (`MessagePeopleList`).

### 💎 Advanced Monetization Logic
* **Smart Native Ads:** Implemented a custom algorithm in `PostAdapter` to inject **Google AdMob Native Ads** seamlessly into the feed (every 6th item).
* **Premium Membership System:**
    * **Code-Based Activation:** Users can upgrade to Premium by entering specific verification codes (`PremiumHesap.java`).
    * **Dynamic UI:** The app checks the user's status (`active`/`inactive`) in real-time to remove ads and unlock VIP profile badges.

### 🎨 Technical Highlights
* **Authentication Security:** Secure login/signup via **Firebase Auth** including **Email Verification** steps and mandatory Privacy Policy acceptance (`Gizlilik_sozlesmesi`).
* **Image Processing:** Integrated **uCrop** library for advanced image cropping and aspect ratio management (1:1, Profile, Matching ratios).
* **Modern UI Toolkit:** Utilizes **Android ViewBinding** for null-safe interaction with XML layouts (replacing `findViewById`).

## 🛠️ Project Structure

The codebase follows the **MVVM (Model-View-ViewModel)** separation principles:

| Module | Description |
| :--- | :--- |
| **`Main/`** (Activities) | Core entry points handling Authentication, Navigation, and Image Cropping logic. |
| **`Fragments/`** | Modular UI components handling the Feed, Matching, Adoption Lists, and User Profile. |
| **`Adapter/`** | Complex `RecyclerView` adapters handling multiple view types (Content vs. Ads) and data binding. |
| **`databinding/`** | Generated binding classes ensuring type-safe view access. |
| **`Model/`** | Data classes representing `Kullanici` (User), `MatchingPet`, and `Post` entities mapped to Firestore documents. |

## ⚙️ Tech Stack & Libraries

* **Language:** Java
* **Backend:** Firebase (Auth, Firestore, Storage)
* **Image Loading:** Picasso
* **Image Cropping:** uCrop
* **Monetization:** Google Mobile Ads SDK (AdMob)
* **Architecture:** MVVM, ViewBinding

## 📄 License

**GNU General Public License v3.0**
See the [LICENSE](LICENSE) file for details.
