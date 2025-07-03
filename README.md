## 🛠️ Recent Changes Summary

The static "Book Therapist" button on the Dashboard has been removed. 
Users can now click on therapist cards in the *Find Therapist* page to navigate to a dynamically loaded *Book Therapist* page. 
Therapist-specific data — such as name, specialty, and bio — is passed between scenes using a new method (`setTherapistData(...)`) in the controller. This allows each booking screen to reflect the selected therapist's profile.
