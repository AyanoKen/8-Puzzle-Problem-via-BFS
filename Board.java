import java.util.Scanner;

class Board
{
    int[][] array = new int[3][3];

    int x;
    int y;

    Board parent;

    Scanner input = new Scanner(System.in);

    Board Clone()
    {
        Board temp = new Board();

        temp.x = x;
        temp.y = y;

        temp.parent = this;

        for(int i=0; i<3; i++)
        {
            for(int j=0; j<3; j++)
            {
                temp.array[i][j] = this.array[i][j];
            }
        }

        return temp;
    }

    void CreateBoard()
    {
        System.out.println("Enter The Values in the Board: ");
        System.out.println("Use '-2' where you want the Blank to be");

        for(int i=0; i<3; i++)
        {
            for(int j=0; j<3; j++)
            {
                System.out.println((i+1) + "," + (j+1) + " : ");
                array[i][j] = input.nextInt();

                if(array[i][j] < 0)
                {
                    x = i;
                    y = j;
                }
            }
        }
    }

    void DisplayBoard()
    {
        for(int i=0; i<3; i++)
        {
            for(int j=0; j<3; j++)
            {
                if(array[i][j] > 0)
                    System.out.print(array[i][j] + " ");
                else
                    System.out.print("  ");
            }
            System.out.println("");
        }
    }

    Board up()
    {
        Board state = new Board();
        int temp;
        
        state.x = this.x;   // Here, I am sure its not shallow copy.
        state.y = this.y;

        state.parent = new Board();
        state.parent = this;  // Does This line truely work?

        for(int i=0; i<3; i++)
        {
            for(int j=0; j<3; j++)
            {
                state.array[i][j] = this.array[i][j];
            }
        }

        if(state.x == 0)
        {
            temp = state.array[x][y];
            state.array[x][y] = state.array[2][y];
            state.array[2][y] = temp;

            state.x = 2;
        }
        else
        {
            temp = state.array[x][y];
            state.array[x][y] = state.array[x-1][y];
            state.array[x-1][y] = temp;

            state.x--;
        }


        return state;
    }

    Board down()
    {
        Board state = new Board();
        int temp;

        state.x = this.x;
        state.y = this.y;
        state.parent = this;  // Does This line truely work?

        for(int i=0; i<3; i++)
        {
            for(int j=0; j<3; j++)
            {
                state.array[i][j] = this.array[i][j];
            }
        }

        if(state.x == 2)
        {
            temp = state.array[x][y];
            state.array[x][y] = state.array[0][y];
            state.array[0][y] = temp;

            state.x = 0;
        }
        else
        {
            temp = state.array[x][y];
            state.array[x][y] = state.array[x+1][y];
            state.array[x+1][y] = temp;

            state.x++;
        }


        return state;
    }

    Board left()
    {
        Board state = new Board();
        int temp;

        state.x = this.x;
        state.y = this.y;
        state.parent = this;  // Does This line truely work?

        for(int i=0; i<3; i++)
        {
            for(int j=0; j<3; j++)
            {
                state.array[i][j] = this.array[i][j];
            }
        }

        if(state.y == 0)
        {
            temp = state.array[x][y];
            state.array[x][y] = state.array[x][2];
            state.array[x][2] = temp;

            state.y = 2;
        }
        else
        {
            temp = state.array[x][y];
            state.array[x][y] = state.array[x][y-1];
            state.array[x][y-1] = temp;

            state.y--;
        }


        return state;
    }

    Board right()
    {
        Board state = new Board();
        int temp;

        state.x = this.x;
        state.y = this.y;
        state.parent = this;  // Does This line truely work?

        for(int i=0; i<3; i++)
        {
            for(int j=0; j<3; j++)
            {
                state.array[i][j] = this.array[i][j];
            }
        }

        if(state.y == 2)
        {
            temp = state.array[x][y];
            state.array[x][y] = state.array[x][0];
            state.array[x][0] = temp;

            state.y = 0;
        }
        else
        {
            temp = state.array[x][y];
            state.array[x][y] = state.array[x][y+1];
            state.array[x][y+1] = temp;

            state.y++;
        }


        return state;
    }
}