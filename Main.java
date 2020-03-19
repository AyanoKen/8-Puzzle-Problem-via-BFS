class Main
{
    public static void main(String[] args) 
    {
        Board initialState;
        Board answerState;

        Board[] answerArray = new Board[25];
        int i = 0;

        initialState = new Board();
        answerState = new Board();

        initialState.CreateBoard();
        answerState.CreateBoard();

        if(Main.BoardEquality(initialState.array, answerState.array))
        {
            System.out.println("Initial State is Equal To The Final State");
        }
        else
        {
            Board current = new Board();
            current = initialState.Clone();

            Queue queue = new Queue(500);

            queue.EnQueue(current);

            while(Main.BoardEquality(current.array, answerState.array) == false)
            {
                queue.EnQueue(current.up());
                queue.EnQueue(current.down());
                queue.EnQueue(current.left());
                queue.EnQueue(current.right());

                queue.DeQueue();

                current = queue.Peek().Clone();
            }

            // At this point, the current object has the answer board.

            while(current != initialState)
            {
                answerArray[i] = current.Clone();
                current = current.parent;
                i++;
            }

            // Now, The answerArray Contains The Path To The Answer Path, But In Reverse
            
            while(i >= 0)
            {
                answerArray[i-1].DisplayBoard();
                System.out.println("");
                i--;
                i--;
            }
        
        } 
    }  

    static boolean BoardEquality(int[][] arr1, int[][] arr2)
    {
        for(int i=0; i<3; i++)
        {
            for(int j=0; j<3; j++)
            {
                if(arr1[i][j] != arr2[i][j])
                    return false;
            }
        }
        return true;
    }
}