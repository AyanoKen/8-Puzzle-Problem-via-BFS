class Queue
{
    Board[] array = new Board[500];

    int front = -1;
    int rear = -1;

    int length = 500;

    Queue(int size)
    {
        array = new Board[size];
        length = size;
    }
    Queue()
    {
        array = new Board[100];
        length = 100;
    }

    void EnQueue(Board board)
    {
        if(rear == length -1)
            System.out.println("The Queue Is Full, Increase The Size Of The Queue");
        else
        {
            if(front == -1)
                front = 0;
            
            rear++;
            array[rear] = board;
            //System.out.println("Inserted into Queue Successfully");
        }
    }

    void DeQueue()
    {
        if(front == -1)
            System.out.println("The Queue Is Empty");
        else
        {
            front++;

            if(front > rear)
            {
                front = -1;
                rear = -1;
            }

            //System.out.println("Removed From Queue Successfully");
        }
    }

    Board Peek()
    {
        return array[front];
    }
}