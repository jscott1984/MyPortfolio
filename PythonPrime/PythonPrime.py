from array import *

class Node:     # Class called Node that hold the data of the run of numbers
    def __init__(self, data = None):
        self.data = data
        self.next = None

class Linked:       # This provide the head and tail of the linked list
    def __init__(self):
        self.head = None
        self.tail = None
    
    def listprint(self):    # This help troubleshoot as I made the program
        printval = self.head# it print out the linked list
        while printval is not None:
            print ("Number ", printval.data)
            printval = printval.next

def main(): # function main
    List1 = Linked()
    
    count = 2
    value = input("Find all primes below what number? ") # prompt the user for a number

    numbers = array('l', [count]) # array of int for the numbers

    for x in range(int(value) - 2):
        count = count + 1
        numbers.append(count)

    MakeLinkedList(List1, numbers)
    FindPrimes(List1)
    WriteFile(List1.head)
    ReadFile()
    calculatePI()
    CoolTrick()

# end of Main function
def CoolTrick():
    x = 2 * 3 * 5 * 7 * 11 + 1
    print("This is a cool trick with prime numbers!")
    print("2 * 3 * 5 * 7 * 11 + 1 = ", x)
    print("The number", x,"is a prime number!")

# end of CoolTrick function

def calculatePI():
    PI = 4.0
    sign = -1
    for x in range(2, 1000000):
        if(sign == -1):
            PI += 4.0/((x*2.0)-1.0) * sign
            sign = 1.0        
        else:
            PI += 4.0/((x*2.0)-1.0) * sign
            sign = -1.0
    print("Value of PI = ", PI)
#end of calculateIP function

def MakeLinkedList(l, n): # This function made the linked list
    for x in n:
        if x == 2:
            l.head = Node(x)
            l.tail = l.head
        else:
            l.tail.next = Node(x)
            l.tail = l.tail.next

# end of MakeLinkedList function

def WriteFile(n):       # write all the primes to the file
    f = open("ListofPrime.txt", "w")
    f.write("List of prime numbers are: ")
    while n.next is not None:
        f.write(str(n.data))
        f.write(" ")
        n = n.next

# end of WriteFile Function

def ReadFile():     # Read from a file and display the prime numbers
    f = open("ListofPrime.txt", "r")
    print(f.read())
    
# end of ReadFile Function
    
def FindPrimes(l):      # This function find the prime numbers from the list that was created
    point = l.head          # Prime used to test other numbers 
    check = l.head          # number that is being tested if it a prime
    
    while point.next is not None:
        while check.next.next is not None:
            if(check.next.data % point.data) == 0:
                check.next = check.next.next
            else:
                check = check.next
        point = point.next
        check = point

# end of FindPrimes Function

main() # start the program at function main
