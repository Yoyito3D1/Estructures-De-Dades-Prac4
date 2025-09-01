# 🎬 Activity 4: Generic MultiList Implementation 

## 📋 Project Description
This activity focuses on implementing a **generic MultiList** that maintains **relationships between two groups of elements**.  
It is mandatory and counts for 10% of the continuous assessment grade.  

The MultiList is composed of **two hash tables**, one for elements of set A and one for elements of set B, along with all the necessary methods to **add, delete, query, and list relationships** between the two sets.

---

## 🚀 Main Features
- Implement `MultiLlista` class according to the `MultiLlistaGenerica` interface.  
- Store elements of **set A** and **set B** using separate hash tables (from Activity 3).  
- Maintain references and relationships between elements of set A and set B.  
- Add new relationships between elements.  
- Delete existing relationships.  
- Query and list all relationships efficiently.  
- Dynamic implementation using **nodes** for the multi-list structure.  
- Iterable functionality to traverse relationships.  

---

## 🛠️ Code Structure
- **MultiLlista.java**: Main class implementing the generic multi-list.  
- **MultiLlistaGenerica.java**: Interface defining all required multi-list operations.  
- **Node classes**: Internal classes to manage relationships and references between elements of set A and B.  
- Uses the **hash table implementation** from Activity 3 to store elements of sets A and B efficiently.  

**Key Methods:**
- `afegir(A a, B b)`: Add a relationship between elements of sets A and B.  
- `esborrar(A a, B b)`: Delete a specific relationship.  
- `consultar(A a, B b)`: Check if a relationship exists.  
- `llistarRelacionsA(A a)`: List all B elements related to A.  
- `llistarRelacionsB(B b)`: List all A elements related to B.  
- `iterable()`: Iterate over all relationships.  

---

## 📋 Usage
1. Implement `MultiLlista` and `MultiLlistaGenerica`.  
2. Use hash tables from Activity 3 to store elements of sets A and B.  
3. Use the provided methods to add, delete, query, and list relationships.  
4. Iterate over the multi-list using the iterable interface.  

> Note: You cannot use `java.util` classes unless explicitly allowed.  

---

## 💻 Requirements
- Java JDK 8 or higher.  
- Custom classes: `MultiLlista`, `MultiLlistaGenerica`, internal node classes, and hash table from Activity 3.  
- Dynamic node-based implementation for the multi-list.  
- Unit tests to validate correct insertion, deletion, query, and traversal of relationships.  

---

## 🎯 Objective
Understand and implement **generic multi-lists**, **relationships between sets**, **node-based dynamic structures**, and integration with **hash tables** for efficient storage and retrieval of data.
