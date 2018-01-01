package slicedtoast.scripts;

import org.powerbot.script.rt4.ClientAccessor;
import org.powerbot.script.rt4.ClientContext;

import java.util.Random;

public abstract class Task extends ClientAccessor
{
    public Task(ClientContext ctx)
    {
        super(ctx);
    }

    public abstract boolean activate();
    public abstract void execute();

    public static void sleep(int time)
    {
        try
        {
            Thread.sleep(time);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }

    public static int getRand(int min, int max)
    {
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }

    public void checkDoor()
    {
        if(ctx.objects.select().id(1535).poll().inViewport()) //if door is closed
        {
            ctx.objects.select().id(1535).poll().interact("Open"); //open it
        }
    }

    public void checkRun()
    {
        if(ctx.movement.energyLevel() >= getRand(80, 100))
        {
            ctx.movement.running(true);
        }
    }
}
