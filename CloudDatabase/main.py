# This is a sample Python script.
import firebase_admin
from firebase_admin import credentials
from firebase_admin import firestore
cred = credentials.Certificate("serviceAccountKey.json")
firebase_admin.initialize_app(cred)

db=firestore.client()


def main():
    value = 0
    displayMenu()
    while(value != '6'):
        if value == '1':
            displayMenu()
        elif value == '2':
            displayItem()
        elif value == '3':
            deleteItem()
        elif value == '4':
            modifyItem()
        elif value == '5':
            insertItem()
        value = input("What do you want to do? ")


def displayMenu():
    # Use a breakpoint in the code line below to debug your script.
    print("1. Display Menu")
    print("2. Display Items")
    print("3. Delete Item ")
    print("4. Modify Item")
    print("5. Insert Item")
    print("6. Quit")


def displayItem():
    items = db.collection('players').document('Joseph').get()
    if items.exists:
        print(items.to_dict())


def deleteItem():
    field = input("What field do you want to delete? ")
    db.collection('players').document('Joseph').update({field :firestore.DELETE_FIELD})

def modifyItem():
    field = input("What field do you want to modify? ")
    item = input("What is the value in the field? ")
    db.collection('players').document('Joseph').set({field: item}, merge=True)

def insertItem():
    field = input("What field do you want to add? ")
    item = input("What is the value in the field? ")
    db.collection('players').document('Joseph').set({field: item}, merge=True)


# Press the green button in the gutter to run the script.
if __name__ == '__main__':
    main()


