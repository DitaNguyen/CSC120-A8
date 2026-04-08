Use this file to record your reflection on this assignment.

- Which methods did you decide to `overload`, and why?
For this assignment, I chose to focus on the most "interactive" part of each subclass to make the simulation feel more realistic:

House.moveIn(): I overloaded this to accept either just a Name or a Name + Floor number. In a real dormitory, you aren't just "in the building" since you usually have a specific room assignment, so adding the int floor parameter made the method much more functional.

Library.checkOut(): I overloaded this to accept a Title or a Title + Number of days. This allows the library to handle standard checkouts while also giving the flexibility to set specific loan durations for different types of media.

Cafe.sellCoffee(): I overloaded this to handle a Size only (for a quick black coffee) or Size + Sugar + Cream. Most people have a "usual" order, so having a simplified version of the method saves time for the programmer and the user.

- What worked, what didn't, what advice would you give someone taking this course in the future?
Inheritance was a huge time-saver. Once the Building.java parent class was set up with the basic enter() and exit() logic, I didn't have to rewrite those for the House or Cafe. It made the code much cleaner and easier to manage.

I ran into some "type mismatch" errors when trying to call overloaded methods. I learned that Java is very picky about Method Signatures. For example, if you send an int but the method is expecting a String, the whole program stops. I also realized that when you overload a method, you have to make sure the original "simple" version still exists if you plan on calling it from the "complex" version.

For future students, I would say that understanding how super.goToFloor(n) works is key. It lets you add your own custom rules (like the Cafe's "1st floor only" rule) without breaking the original movement logic.