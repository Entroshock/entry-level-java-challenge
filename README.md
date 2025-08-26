# My Thought Process on tackling ReliaQuest's Entry-Level Java Challenge

## Problem Statement
- Reading the problem statement I concurred that I needed to basically build a "translator" that could let the new SaaS talk to the old system being used by the company.
- I had to build a REST API with 3 given endpoints that could do two different type of GET requests and a POST in relation to the employees, while making sure we comply to clear and concise design methodologies.
- Though I was free to ask questions in relation to this challenge, I decided to interpret the task as it was laid out for now; in a real life scenario I would be asking many questions to clarify what is expected.

## Design Process
After going through the problem statement and looking through the files and doing some reading on Springboot, I logically thought about some decisions to make:

### Understanding the structure
- Add a service layer as requested
- Use mock data as there was no need for a real database
- Use a hashmap for key-value storage(UUID lookup + simple)
- Employee interface meant I needed to create a class that handles the employee data

## Controller Implementation
I had to update the existing controller and use proper spring annotations(@GetMapping etc.)
### How I visualized the implementation
![alt text](https://github.com/Entroshock/entry-level-java-challenge/blob/main/getallemployee.png)
![alt text](https://github.com/Entroshock/entry-level-java-challenge/blob/main/getemployeeuuid.png)
![alt text](https://github.com/Entroshock/entry-level-java-challenge/blob/main/postcreateemployee.png)

### How the Components would work
![alt text](https://github.com/Entroshock/entry-level-java-challenge/blob/main/components.png)

## Conclusion
- This challenge made me rack my brain on how to come up with a solution to a fairly simple problem, but behind it lies a lot of complexity to it in a real world situation in my opinion.
- I feel like my decision may not be correct but this is what works best for me now currently; there are definitely a lot more enchancements that I feel like that would need to be added in a prod environment, things like Security(Auth), testing etc.
- Overall I believe there's a lot of room for improvement in the future.
