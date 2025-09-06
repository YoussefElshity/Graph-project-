# Graph Properties Checker  

This project is a **Java console application** that allows users to input a graph (via adjacency and incidence matrices) and checks various graph properties. It can determine whether a graph is **reflexive, symmetric, transitive, acyclic, connected,** and whether it contains an **Eulerian path**.  

---

## 📌 Features  
The program provides the following functionality:  

1. **Read adjacency matrix input**  
   - User provides the number of rows and columns.  
   - Fills the adjacency matrix from console input.  

2. **Check graph properties using the adjacency matrix**  
   - **Reflexive** → Verifies that every vertex has a self-loop.  
   - **Symmetric** → Checks if the relation is symmetric.  
   - **Transitive** → Checks if the relation is transitive.  
   - **Acyclic** → Detects if the graph has no cycles.  
   - **Connected** → Determines if the graph is fully connected.  

3. **Read incidence matrix input**  
   - User provides the number of rows and columns.  
   - Fills the incidence matrix from console input.  

4. **Check Eulerian path**  
   - Determines if the graph contains an **Eulerian path** using in-degree and out-degree of vertices.  

---

## 🛠️ How It Works  

- The program prompts the user for:  
  1. **Adjacency matrix dimensions and values.**  
  2. **Incidence matrix dimensions and values.**  

- It then performs the following checks:  
  - Prints whether the graph is **Reflexive, Symmetric, Transitive, Acyclic, Connected.**  
  - Prints whether it has an **Eulerian Path.**  

---

## ▶️ Running the Program  

1. Compile the Java file:  
   ```bash
   javac Main.java
   ```

2. Run the program:  
   ```bash
   java Main
   ```

3. Follow the prompts to enter matrix values.  

---

## 📖 Example Input / Output  

### Input:
```
number of rows in adjacencyMatrix
3
number of colm in adjacencyMatrix
3
the 1 row
1 1 0
the 2 row
1 1 1
the 3 row
0 1 1
```

### Output:
```
this is Reflexive
this is Symmetric
this is Transitive
this is connected
```

---

## 📂 Project Structure  

```
├── Main.java        # Source code
├── README.md        # Project documentation
```

---

## 🚀 Future Improvements  

- Add support for **directed vs undirected graphs**.  
- Visualize the graph from the adjacency/incident matrix.  
- Provide a menu-driven interface for easier navigation.  
