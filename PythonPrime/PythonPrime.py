from array import *

class Node:
    def __init__(data = int):
        Node.data = int
        Node.Head = Node
        Node.Tail = Node

List = Node()
List.Head = List
List.Tail = List

count = 2
value = input("Find all primes below what number? ")

numbers = array('l', [count])

for x in range(int(value) - 2):
    count = count + 1
    numbers.append(count)

for x in range(int(value) - 2):
    List.data = numbers[x]
    print(" list of Numbers ", List.data)

for x in numbers:
    print(" list of Numbers ", x)

