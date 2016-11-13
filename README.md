# SpringNature
Test task for Spring Nature
Contains:
 - Negative test-scenario (attempt to find non-existing string)
 - Simple positive test-scenario (attempt to find very common word and check existance in the title of the first search result)
 - Advanced search among titles (string "ellen" gives clear executipn, string "cpp" discovers a bug). Bug description: on attempt
 to find string "cpp" title on 80th position we have title "Chinese postman problem".
 - Demo-video

 Works with FF 46.0 and Selenium 2.45 (as Selenium 3.0 requires different architecture please don't run tests on it)
