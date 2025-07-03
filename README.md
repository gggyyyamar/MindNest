## Recent Changes Summary

### Removed: Static "Book Therapist" Button from Dashboard

- The **static booking button** on the Dashboard was removed.
- Booking logic is no longer hardcoded to a general booking page.
- This change improves navigation flow and enables therapist-specific context.

---

### Added: Clickable Therapist Cards on *Find Therapist* Page

- Therapist cards in the **Find Therapist** (`FindTherapist.fxml`) view are now interactive.
- Clicking a therapist:
  - Navigates to the **Book Therapist** page (`BookTherapist.fxml`)
  - Passes the selected therapist's **name** and **specialty** dynamically

---

### Introduced: Dynamic Data Passing Between Scenes

- The booking screen is no longer hardcoded with therapist info.
- A method `setTherapistData(String name, String specialty)` was added to `BookTherapistController`.
- Therapist bio and label content are now **loaded based on the selected therapist**.

---
