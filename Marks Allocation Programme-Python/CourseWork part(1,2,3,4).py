def exam_marks():
    Attempt_1 = 0
    Attempt_2 = 0
    Attempt_3 = 0
    Attempt_4 = 0 
    l,m,n,o,p,q,r = 0,20,40,60,80,100,120
    Turn_Pro=[]
    Turn_ProMt=[]
    Turn_Exc=[]
    Turn_Modr=[]
    while True:
        print()
        while True:
            while True:
                try:
                    x = int(input("Please enter your credits at pass: "))
                    break
                except ValueError:
                    print("Integer required")
            if (x == l or x == m or x == n or x == o or x == p or x == q or x == r):
                break
            else:
                print("Out of range")
        while True:
            while True:
                try:
                    y = int(input("Please enter your credits at defer: "))
                    break
                except ValueError:
                    print("Integer required")
            if (y == l or y == m or y == n or y == o or y == p or y == q or y == r):
                break
            else:
                print("Out of range")
        while True:
            while True:
                try:
                    z = int(input("Please enter your credits at fail: "))
                    break
                except ValueError:
                    print("Integer required")
            if (z == l or z == m or z == n or z == o or z == p or z == q or z == r):
                break
            else:
                print("Out of range")
        total = x + y + z
        if (total != 120):
            print("Total incorrect")
        elif (x == 120 ):
            print("Progress")
            Turn_Pro.append(x)
            Turn_Pro.append(y)
            Turn_Pro.append(z)
            nested=[Turn_Pro]
            Attempt_1 = Attempt_1 + 1
        elif (x == 100):
            print("Progress (module trailer)")
            Attempt_2 = Attempt_2 + 1
            Turn_ProMt.append(x)
            Turn_ProMt.append(y)
            Turn_ProMt.append(z)
        elif (x <= 40 and y <= 40 and z >= 80 ):
            print("Exclude")
            Attempt_4 = Attempt_4 + 1
            Turn_Exc.append(x)
            Turn_Exc.append(y)
            Turn_Exc.append(z)
        elif (x < 100):
            print("Module retriever")
            Attempt_3 = Attempt_3 + 1
            Turn_Modr.append(x)
            Turn_Modr.append(y)
            Turn_Modr.append(z)
        while True:
            print()
            print("Would you like to enter another set of data?")
            result = input("Enter 'y' for yes or 'q' to quit and view results: ")
            if (result == 'y' or result == 'q'):
                break            
        if result == 'q':
            break
        elif result == 'y':
            continue
    print()
    print("--------------------------------------------------------------------------------")
    print("Horizontal Histogram")
    print("Progress",Attempt_1,'\t',': ','*' *Attempt_1)
    print("Trailer",Attempt_2,'\t',': ' ,'*' *Attempt_2)
    print("Retriever",Attempt_3,'\t',': ','*' *Attempt_3)
    print("Excluded",Attempt_4,'\t',': ','*' *Attempt_4)
    print()
    tot_count = Attempt_1 + Attempt_2 + Attempt_3 + Attempt_4
    print(tot_count,"outcomes in total.")
    print("--------------------------------------------------------------------------------")
    print("Vertical Histogram")
    header = ['Progress ', 'Trailer ', 'Retriever ', 'Excluded ']
    print(' '.join(header))
    for x in range(max(Attempt_1, Attempt_2, Attempt_3, Attempt_4)):
        print ("    {0}         {1}         {2}         {3}".format(
            '*' if x < Attempt_1 else ' ',
            '*' if x < Attempt_2 else ' ',
            '*' if x < Attempt_3 else ' ',
            '*' if x < Attempt_4 else ' '
        ))
    print("--------------------------------------------------------------------------------")
    print()
    for i in range (Attempt_1):
        print ("Progress -"  , end=" ")
        print (*Turn_Pro[0:3] , sep= ", ")
        del Turn_Pro [0:3]
    for i in range (Attempt_2):
        print ("Progress (module trailer) -"  , end=" ")
        print (*Turn_ProMt[0:3] , sep= ", ")
        del Turn_ProMt  [0:3]
    for i in range (Attempt_3):
        print ("Module retriever -"  , end=" ")
        print (*Turn_Modr[0:3] , sep= ", ")
        del Turn_Modr  [0:3]
    for i in range (Attempt_4):
        print ("Exclude -"  , end=" ")
        print (*Turn_Exc[0:3] , sep= ", ")
        del Turn_Exc  [0:3]

exam_marks()
