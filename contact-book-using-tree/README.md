# Contact Book using Tree Nodes to represent characters

This repository contains Java classes that constructs a Name tree (data structure) used to store names of contacts from an input file such as "ContactInformation.txt"

These Java classes apply theoretical Data Structures (Trees) and Algorithms such as insertion, search, and removal.

Each contact should store a name and phone number.

The phone number associated with each contact is stored in a leaf node.

The beauty of using this particular data structure to store contacts is that similar names share the same characters going down the tree.

For example, Jeremiah and Jeremy would share the same characters ("J" "e" "r" "e" "m") at the beginning of their name.

The contact book supports basic commands such as adding, searching or deleting a person. The contact book can also add a node or update a phone number. Contact information can be read in from an input file.

This project demonstrates how to: Read in from a file, Create Advanced objects such as Nodes, Create and use Tree Structures, load input files and insert into a Data Structure.

The TreeNode class creates a Tree Linked object containing a few parameters and getters and setter methods.

The ContactTree class creates a Tree object that has a constructor and methods such as addPerson, addNode, deletePerson, searchPerson, updatePhoneNumber and ReadInputFile. This class uses Java libraries to load input from a .txt file to populate the Tree.
