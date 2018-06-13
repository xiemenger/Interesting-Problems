class SnakeGame {

    /** Initialize your data structure here.
        @param width - screen width
        @param height - screen height 
        @param food - A list of food positions
        E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    int width;
    int height;
    int[][] food;
    Set<Integer> bodyset;
    Deque<Integer> body;
    int score;
    int foodIdx;
    
    public SnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        this.food = food;
        bodyset = new HashSet<>();
        body = new LinkedList<>();
        bodyset.add(0);
        body.addFirst(0);
        score = 0;
        foodIdx = 0;
    }
    
    /** Moves the snake.
        @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down 
        @return The game's score after the move. Return -1 if game over. 
        Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        if (score == -1){
            return -1;
        }
        
        int hrow = body.peekFirst() / width;
        int hcol = body.peekFirst() % width;
        switch(direction){
            case "U" : hrow--; break;
            case "L" : hcol--; break;
            case "R" : hcol++; break;
            case "D" : hrow++; break;
        }
        int newhead = hrow*width + hcol;
        // case1: hit wall or eat body
        bodyset.remove(body.peekLast()); // since sneak move forward, the last should be disappear.
        if (hrow < 0 || hrow >= height || hcol < 0 || hcol >= width || bodyset.contains(newhead)){
            return -1;
        }
        
        bodyset.add(newhead);
        body.addFirst(newhead);
        // case2: this move eats food
        if (foodIdx < food.length && hrow == food[foodIdx][0] && hcol == food[foodIdx][1]){
            bodyset.add(body.peekLast()); // sneak's length increase by 1, keep the tail.
            foodIdx++;
            return ++score;
        }
        
        // case3: normal move
        body.pollLast();
        return score;
    }
}