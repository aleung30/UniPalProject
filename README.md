# My Personal Project

# The Vision Behind UniPal

Do you often feel overwhelmed by the stress and challenges of university, yet struggle to manage the emotional rollercoaster? Have you ever wondered how your mood fluctuates as you undergo the pressures of post-secondary? With *UniPal*, users will be able to add and view accomplishments in their *Accomplishment Collection*, add and view moods in their *Mood Collection*, keep track of previously logged mood names, and receive personalized recommendations for relaxation methods based on mood type.

As a second-year university student, I have noticed that many of my peers, including myself, have struggled with adjusting to post-secondary. Thus, the main users of this application will be **university students**, who want to track and reflect on their mental well-being over the course of the semesters. By providing a tool to help fellow students navigate this transition, we can promote open conversations about mental health and help reduce the stigma surrounding it. 

**User Stories**
- As a user, I want to be able to add a mood to the Mood Collection
- As a user, I want to be able to view all of my moods in the Mood Collection
- As a user, I want to be able to check if one of my mood names is already within the Mood Collection
- As a user, I want to receive recommendations for relaxation methods based on my mood
- As a user, I want to be able to add an accomplishment to the Accomplishment Collection
- As a user, I want to be able to view all of my accomplishments in the Accomplishment Collection
- As a user, I want to be given the option to save my UniPalBoard to file
- As a user, I want to be given the option to load my UniPalBoard from file

**Instructions for End User**

- To run the GUI, please run the **MainMenu** class in the ui package
- You can generate the first required action related to the user story "adding multiple Xs to a Y" by clicking the "Add an Accomplishment" button
- You can generate the second required action related to the user story "adding multiple Xs to a Y" by clicking the "Remove an accomplishment!" button
- You can locate my visual component by simply running the **MainMenu** class and viewing the splash screen
- You can save the state of UniPal by clicking the "Save your UniPal!" button
- You can reload the state of UniPal by clicking the "Load your UniPal!" button

**Phase 4: Task 2**

- When the user quits the application, all of the add and remove events should be printed to the console with the date and time like the example below: 

Logged Events
Added an accomplishment to your collection.
Fri Nov 29 21:16:22 PST 2024
Removed an accomplishment from your collection.
Fri Nov 29 21:16:41 PST 2024

	If I had more time to work on the UniPal application, I would simplify the design by removing the redundant and duplicate code within the AccomplishmentCollection and MoodCollection classes. Within my UniPalBoard class in the model package, I declare a field of type AccomplishmentCollection and MoodCollection, and it holds methods such as adding, returning the collections, and checking if certain mood names are contained inside of a collection. However, all of these methods are also inside of the AccomplishmentCollection and MoodCollection classes as well, which resulted in substantial duplicated code. 

	To improve this code duplication, I would refactor this by removing the AccomplishmentCollection and MoodCollection classes entirely and instantiating lists of type Mood and Accomplishment within the UniPalBoard class directly instead, so there will not be any code duplication. By removing this redundant code, the overall behaviour of the application remains the same while improving the concept of single point of control as any changes made to the AccomplishmentCollection and MoodCollection lists only need to be changed within the UniPalBoard class rather than needing to potentially make changes in 3 different classes.







  