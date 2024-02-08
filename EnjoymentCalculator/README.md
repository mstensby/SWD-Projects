[Home](https://github.com/mstensby)

### Problem Statement
You have arrived at Grandma's house, and she has Turkey, Stuffing, Pie, Mac and Cheese, Mashed Potatoes, Gravy, and Corn Casserole ready to be served. Although you wish you could eat everything, your stomach has a max capacity. Each food has an associated weight and enjoyment level that is assigned by the user. The goal is to find the highest amount of enjoyment possible while maintaining your stomach capacity.

### User Documentation
To begin, run the program and type out the weight and enjoyment level of each food in the command line. After this is done, you will type in your max capacity for your stomach and then the optimal enjoyment rating will be displayed. 

### Developer Documentation
There are two classes that will be used: a driver program that asks the user for the weight and enjoyment level of each of the foods and a class that calculates the optimal enjoyment rating for their meal. This optimal enjoyment rating should be found by first finding the food that has the highest enjoyment rating for the least amount of weight. After the most efficient ratio is found, the associated weight of that food should be subtracted off of the user's max stomach capacity. After their max capacity cannot handle any more of that weight, the next best ratio should be used. This process should repeat until the stomach capacity is at 0 or cannot handle any more food (if any).  After the optimal enjoyment is calculated, it should be printed to the screen through the main program. 

[Thanksgiving JavaDocs](http://localhost:8000/mstensby/oral_exam2/AdvancedTopics2/doc/package-summary.html)

![image](https://github.com/mstensby/SWD-Projects/assets/156954799/48d814ea-df16-4f56-b04c-b81d58e39620)


### Source Code

[EnjoymentCalculatorDriver](https://class-git.engineering.uiowa.edu/swd2023fall/mstensby/-/blob/main/oral_exam2/AdvancedTopics2/src/EnjoymentCalculatorDriver.java)

[EnjoymentCalculator](https://class-git.engineering.uiowa.edu/swd2023fall/mstensby/-/blob/main/oral_exam2/AdvancedTopics2/src/EnjoymentCalculator.java)
