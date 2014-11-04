#Hardcore coderetreat on 4-5 November 2014, Bucharest, Romania

#Attendees
Adi Bolboacă, Alex Bolboacă, Aki Salmi, Peter Kofler, Sandro Mancuso, Samir Talwar

##Day 1

###First session
####What we did
We created a startup application. We used Java with 
It took us 45 minutes

####Retrospective

#####Good
Feel like moving forward
We had a chance to have three programmers during the first session
It compiles on both IntelliJ and Eclipse
A shaky start in the beginning, but we know what we are doing now

#####Improvements
Let's focus more on the details
Already we have "lazy" code
We are focusing too much on HTML tags
Start asking some challenging questions, maybe during retrospective


####Second session
Discussed if we want to continue on horizontal slices or vertical slices of functionality. 
We created a new page where all the pairs that are searching for programmers to pair with are listed. We decided to have the list with the timeslots where each of the programmers are available. For each list item we added a button where one can notify a pair about a session.

#####Good
Enjoyed to find what the application is about 
We are gaining context about what we are doing
The reals applications I like working in this way, it's not just getting the reuirements implemented, but also having flexibility to change things. Where we have enough we can add more from the features.
Less debate about the things we are doing

#####Improvements
A little frustrating that we do not have functionality implemented
There is a lot of duplication in the HTML files
Let's focus on confirm/reject functionality and then we can have the basic functionality
Less emphasis on shortcuts. Don't tell shortcuts to people who are writing unless whoever is writing is not asking.
Write all the shortcuts on a whiteboard.
Felt we had less progress than in the first session


####Third session
We completed the user journey of a programmer to invite and the accept or reject the invitation.
We added a tag in github 'hardcoded-flow'

#####Good
Finished hardcoding, we can get down to sending email
Making progress, working better. 
Even a short iteration, we did more
Working better with each others
Found something and immediately fixed it
Method naming got better
We were more focused

#####Improvements
nothing to add... we were perfect

####Lunch
We came back after 1 hour and 22 minutes.

####Fourth session
We refactored the code and discussed about the design we need to follow

#####Good
We made product
Some of the people did not feel included in the discussions
We changed a lot of things, we separated the things that did not belong together
We had rotation, around 4 people were at the keyboard

#####Improvements
We should draw things when we are disagreeing
Focus more on finishing the first increment of the product
Too many people talked in the same time too often and we could not understand what we need to do next
We should have something we end so we could have a codebase we can start playing with
Try to do a 25' session

####Fifth session
Session was 25 minutes. We created first test for email.

#####Good
Drawing helped, clarified and brought up discussion.
We started testing because we have behaviour now.

#####Improvements
Driver was sitting 25 mintes, bad.
We avoid the domain, need to explore the domain.
25 minutes is too short. Try again 45 minutes.
Adi and Alex need to be more involved.


####Sixth session
Session was 45 minutes
We wrote more tests on sending emails for sending a pair-programming invitation

#####Good
We are progressing

#####Improvements
We are slowing down
We are having a lot of negotiations
Some of us are getting tired about the big discussions
We are creating more and more shit


##Day2

####First session
Alex and Aki continued with the code from yesterday that Alex created with Samir
Sandro and Adi discussed about Sandro's approach to write the code in a more mockist approach and how the structure is very simmilar as when one would use classicist approach, but after more refactoring. 
Samir talked about ATDD, and he will like to write only one acceptance test, without unit tests and at the moment when it's too big, write other tests

####Second Session
Samir and Peter are having slow progress, but discussing a lot about design. Some small things are happening when driving the design. It's taking a lot of time to rename the things

Aki and Alex continue the exhibit stuff, now they have a failing test to add a second type of test. Now the pages class is forming in a way that it will provide pages to be rendered, based on the domain classes that will be given. Refactored a lot the page loading into a different class. Another interesting thing, it drives Aki mad to work with Eclipse shortcuts.

Adi and Sandro are adding the functionality to find a pair by location. They wrote a first test that took too long. Even if we have classicist and mockist aproach, when writing a test we both start from the bottom part of the test, the assert part. Also we are doing the same kind of refactorings on test and production code.

Adi is writing the assertions first, and only at the end writing the name of the test, after it's green. Sandro wants to write with the name of the test. Samir would write the commit message first and if the test isn't doing what the commit message says, would reset the changes and go back.


####Showing the code session
We showed code during the session. Alex showed what he did with Samir and Aki. Sandro showed what he did with Adi. Samir showed what he did with Peter.

We all enjoyed the code that we did. It was very different, and everyone really cared about the code.
We covered different types of testing, acceptance testing, 
The format on the orgininal mob-programming gave us context and everyone knew what we are doing and then we could have started differnt things on our own. Sandro liked the format.
For a new team it might not be clever to start with the mob.
We missed a warm-up session before the mob programming session yesterday. 
We could try the mob programming with another group. 
Seeing the code was useful.
If the initial code were simpler, it would have been easier to continue with them. We should have started with something even simpler. The lack of preparation maybe was the cause of this too complicated structure of the initial code.
The last session about presenting the code could have been shorter than one hour.
Enjoyed that while showing the code there were questions and discussions about how the code looked or could look like. ALl of us learned something new.

#####Improvements
Some of us were disengaged during the showing the code presentation.
It's not that easy to have timeboxed sessions for showing code. Maybe it's a better idea that anyone who does not find value in the presentation to say so to the presenter.
