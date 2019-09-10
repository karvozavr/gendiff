# GenDiff

This app takes 2 java files and prints to console their ASTs difference between their ASTs in terms of operations with tree nodes.

Also fancy code diff based on this AST data is shown at http://localhost:4567.

Created by: Dmitrii Abramov.

## Usage

Run using gradle:

`./gradlew run --args "file1.java" "file2.java"`

Or you may download packed app [here](https://github.com/karvozavr/gendiff/releases) and run it:

`./bin/gentree file1.java file2.java`

## Implementation Details

AST is shown in text form and obtained from file using `Generators.getTree(file)` from `GumTree` framework. 

Difference in terms of operations with nodes is implemented using `EditScript` generation. 
It is a set of operations obtained from `Mappings` of nodes between 2 trees using the _Chawathe’s edit distance algorithm_ implementation from `GumTree` framework.  

Fancy web view of diff is made using `WebDiff` tool from `GumTree`.