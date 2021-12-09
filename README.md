# Financial planning Group Marbles

A financial planner that supports using multiple users and can handle multiple users concurrently.
# System requirements:
  To run, you need Java version 11 (more specifically, we've been using Amazon Corretto version 11.0.13)

## Installation Instructions

1. git clone https://github.com/CSC207-UofT/course-project-marble
 
2. Run the Server from the server package

3. If you are using it locally you may skip the next 2 steps

4. Forward port 8000 to the machine the server will be running on

5. In ClientUI set the IP to the remote machine. It is set to 127.0.0.1 by default

6. Run the clientUI and it will connect to the server.

## What can be done in program
Upon running the program, Users will be prompted to login or create an account (and then login). 

Once the user logins they will be shown the various different actions that they can do in
their account and how to call for those action. 
These actions include:
  1) looking at their account information
  
  2) creating a savings account
  
  3) viewing their investments
  
  4) looking at their budget
  
  5) comparing their budget to a standard optimal budget
  
  6) and much more

Note: The app is meant to act as a financial planner. Actions made in the program such as creating a 
savings account or cashing out a bond are meant to act as a sort of tracker of actual actions done in 
real life by the user.
