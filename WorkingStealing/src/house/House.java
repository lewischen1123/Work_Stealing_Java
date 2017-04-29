package house;//####[1]####
//####[1]####
import java.awt.Color;//####[3]####
import java.awt.Dimension;//####[4]####
import java.awt.Font;//####[5]####
import java.awt.Graphics;//####[6]####
import java.util.ArrayList;//####[7]####
import java.util.Collection;//####[8]####
import java.util.Collections;//####[9]####
import java.util.Iterator;//####[10]####
import java.util.List;//####[11]####
import java.util.concurrent.ConcurrentLinkedQueue;//####[12]####
import java.util.concurrent.CopyOnWriteArrayList;//####[13]####
import javax.swing.JApplet;//####[15]####
import javax.swing.SwingUtilities;//####[16]####
//####[16]####
//-- ParaTask related imports//####[16]####
import pt.runtime.*;//####[16]####
import java.util.concurrent.ExecutionException;//####[16]####
import java.util.concurrent.locks.*;//####[16]####
import java.lang.reflect.*;//####[16]####
import pt.runtime.GuiThread;//####[16]####
import java.util.concurrent.BlockingQueue;//####[16]####
import java.util.ArrayList;//####[16]####
import java.util.List;//####[16]####
//####[16]####
public class House extends JApplet {//####[18]####
    static{ParaTask.init();}//####[18]####
    /*  ParaTask helper method to access private/protected slots *///####[18]####
    public void __pt__accessPrivateSlot(Method m, Object instance, TaskID arg, Object interResult ) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {//####[18]####
        if (m.getParameterTypes().length == 0)//####[18]####
            m.invoke(instance);//####[18]####
        else if ((m.getParameterTypes().length == 1))//####[18]####
            m.invoke(instance, arg);//####[18]####
        else //####[18]####
            m.invoke(instance, arg, interResult);//####[18]####
    }//####[18]####
//####[20]####
    private Build builder;//####[20]####
//####[22]####
    private int width = 500;//####[22]####
//####[23]####
    private int height = 320;//####[23]####
//####[25]####
    private int N = 20;//####[25]####
//####[26]####
    private boolean clearScreen = true;//####[26]####
//####[28]####
    private CopyOnWriteArrayList<BuildingMaterial> foundation = null;//####[28]####
//####[29]####
    private CopyOnWriteArrayList<BuildingMaterial> wallSiding = null;//####[29]####
//####[30]####
    private CopyOnWriteArrayList<BuildingMaterial> roofTiles = null;//####[30]####
//####[31]####
    private CopyOnWriteArrayList<BuildingMaterial> windows = null;//####[31]####
//####[33]####
    private BuildingMaterial door = null;//####[33]####
//####[34]####
    private BuildingMaterial forSaleSign = null;//####[34]####
//####[36]####
    private Color colorRoof;//####[36]####
//####[37]####
    private Color colorWalls;//####[37]####
//####[39]####
    public House(Build builder) {//####[39]####
        this.builder = builder;//####[40]####
        setPreferredSize(new Dimension(width, height));//####[41]####
        initialiseMaterial();//####[42]####
    }//####[43]####
//####[46]####
    private static volatile Method __pt__buildSingleTask_Color_Color_method = null;//####[46]####
    private synchronized static void __pt__buildSingleTask_Color_Color_ensureMethodVarSet() {//####[46]####
        if (__pt__buildSingleTask_Color_Color_method == null) {//####[46]####
            try {//####[46]####
                __pt__buildSingleTask_Color_Color_method = ParaTaskHelper.getDeclaredMethod(new ParaTaskHelper.ClassGetter().getCurrentClass(), "__pt__buildSingleTask", new Class[] {//####[46]####
                    Color.class, Color.class//####[46]####
                });//####[46]####
            } catch (Exception e) {//####[46]####
                e.printStackTrace();//####[46]####
            }//####[46]####
        }//####[46]####
    }//####[46]####
    public TaskID<Void> buildSingleTask(Color colorWalls, Color colorRoof) {//####[46]####
        //-- execute asynchronously by enqueuing onto the taskpool//####[46]####
        return buildSingleTask(colorWalls, colorRoof, new TaskInfo());//####[46]####
    }//####[46]####
    public TaskID<Void> buildSingleTask(Color colorWalls, Color colorRoof, TaskInfo taskinfo) {//####[46]####
        // ensure Method variable is set//####[46]####
        if (__pt__buildSingleTask_Color_Color_method == null) {//####[46]####
            __pt__buildSingleTask_Color_Color_ensureMethodVarSet();//####[46]####
        }//####[46]####
        taskinfo.setParameters(colorWalls, colorRoof);//####[46]####
        taskinfo.setMethod(__pt__buildSingleTask_Color_Color_method);//####[46]####
        taskinfo.setInstance(this);//####[46]####
        return TaskpoolFactory.getTaskpool().enqueue(taskinfo);//####[46]####
    }//####[46]####
    public TaskID<Void> buildSingleTask(TaskID<Color> colorWalls, Color colorRoof) {//####[46]####
        //-- execute asynchronously by enqueuing onto the taskpool//####[46]####
        return buildSingleTask(colorWalls, colorRoof, new TaskInfo());//####[46]####
    }//####[46]####
    public TaskID<Void> buildSingleTask(TaskID<Color> colorWalls, Color colorRoof, TaskInfo taskinfo) {//####[46]####
        // ensure Method variable is set//####[46]####
        if (__pt__buildSingleTask_Color_Color_method == null) {//####[46]####
            __pt__buildSingleTask_Color_Color_ensureMethodVarSet();//####[46]####
        }//####[46]####
        taskinfo.setTaskIdArgIndexes(0);//####[46]####
        taskinfo.addDependsOn(colorWalls);//####[46]####
        taskinfo.setParameters(colorWalls, colorRoof);//####[46]####
        taskinfo.setMethod(__pt__buildSingleTask_Color_Color_method);//####[46]####
        taskinfo.setInstance(this);//####[46]####
        return TaskpoolFactory.getTaskpool().enqueue(taskinfo);//####[46]####
    }//####[46]####
    public TaskID<Void> buildSingleTask(BlockingQueue<Color> colorWalls, Color colorRoof) {//####[46]####
        //-- execute asynchronously by enqueuing onto the taskpool//####[46]####
        return buildSingleTask(colorWalls, colorRoof, new TaskInfo());//####[46]####
    }//####[46]####
    public TaskID<Void> buildSingleTask(BlockingQueue<Color> colorWalls, Color colorRoof, TaskInfo taskinfo) {//####[46]####
        // ensure Method variable is set//####[46]####
        if (__pt__buildSingleTask_Color_Color_method == null) {//####[46]####
            __pt__buildSingleTask_Color_Color_ensureMethodVarSet();//####[46]####
        }//####[46]####
        taskinfo.setQueueArgIndexes(0);//####[46]####
        taskinfo.setIsPipeline(true);//####[46]####
        taskinfo.setParameters(colorWalls, colorRoof);//####[46]####
        taskinfo.setMethod(__pt__buildSingleTask_Color_Color_method);//####[46]####
        taskinfo.setInstance(this);//####[46]####
        return TaskpoolFactory.getTaskpool().enqueue(taskinfo);//####[46]####
    }//####[46]####
    public TaskID<Void> buildSingleTask(Color colorWalls, TaskID<Color> colorRoof) {//####[46]####
        //-- execute asynchronously by enqueuing onto the taskpool//####[46]####
        return buildSingleTask(colorWalls, colorRoof, new TaskInfo());//####[46]####
    }//####[46]####
    public TaskID<Void> buildSingleTask(Color colorWalls, TaskID<Color> colorRoof, TaskInfo taskinfo) {//####[46]####
        // ensure Method variable is set//####[46]####
        if (__pt__buildSingleTask_Color_Color_method == null) {//####[46]####
            __pt__buildSingleTask_Color_Color_ensureMethodVarSet();//####[46]####
        }//####[46]####
        taskinfo.setTaskIdArgIndexes(1);//####[46]####
        taskinfo.addDependsOn(colorRoof);//####[46]####
        taskinfo.setParameters(colorWalls, colorRoof);//####[46]####
        taskinfo.setMethod(__pt__buildSingleTask_Color_Color_method);//####[46]####
        taskinfo.setInstance(this);//####[46]####
        return TaskpoolFactory.getTaskpool().enqueue(taskinfo);//####[46]####
    }//####[46]####
    public TaskID<Void> buildSingleTask(TaskID<Color> colorWalls, TaskID<Color> colorRoof) {//####[46]####
        //-- execute asynchronously by enqueuing onto the taskpool//####[46]####
        return buildSingleTask(colorWalls, colorRoof, new TaskInfo());//####[46]####
    }//####[46]####
    public TaskID<Void> buildSingleTask(TaskID<Color> colorWalls, TaskID<Color> colorRoof, TaskInfo taskinfo) {//####[46]####
        // ensure Method variable is set//####[46]####
        if (__pt__buildSingleTask_Color_Color_method == null) {//####[46]####
            __pt__buildSingleTask_Color_Color_ensureMethodVarSet();//####[46]####
        }//####[46]####
        taskinfo.setTaskIdArgIndexes(0, 1);//####[46]####
        taskinfo.addDependsOn(colorWalls);//####[46]####
        taskinfo.addDependsOn(colorRoof);//####[46]####
        taskinfo.setParameters(colorWalls, colorRoof);//####[46]####
        taskinfo.setMethod(__pt__buildSingleTask_Color_Color_method);//####[46]####
        taskinfo.setInstance(this);//####[46]####
        return TaskpoolFactory.getTaskpool().enqueue(taskinfo);//####[46]####
    }//####[46]####
    public TaskID<Void> buildSingleTask(BlockingQueue<Color> colorWalls, TaskID<Color> colorRoof) {//####[46]####
        //-- execute asynchronously by enqueuing onto the taskpool//####[46]####
        return buildSingleTask(colorWalls, colorRoof, new TaskInfo());//####[46]####
    }//####[46]####
    public TaskID<Void> buildSingleTask(BlockingQueue<Color> colorWalls, TaskID<Color> colorRoof, TaskInfo taskinfo) {//####[46]####
        // ensure Method variable is set//####[46]####
        if (__pt__buildSingleTask_Color_Color_method == null) {//####[46]####
            __pt__buildSingleTask_Color_Color_ensureMethodVarSet();//####[46]####
        }//####[46]####
        taskinfo.setQueueArgIndexes(0);//####[46]####
        taskinfo.setIsPipeline(true);//####[46]####
        taskinfo.setTaskIdArgIndexes(1);//####[46]####
        taskinfo.addDependsOn(colorRoof);//####[46]####
        taskinfo.setParameters(colorWalls, colorRoof);//####[46]####
        taskinfo.setMethod(__pt__buildSingleTask_Color_Color_method);//####[46]####
        taskinfo.setInstance(this);//####[46]####
        return TaskpoolFactory.getTaskpool().enqueue(taskinfo);//####[46]####
    }//####[46]####
    public TaskID<Void> buildSingleTask(Color colorWalls, BlockingQueue<Color> colorRoof) {//####[46]####
        //-- execute asynchronously by enqueuing onto the taskpool//####[46]####
        return buildSingleTask(colorWalls, colorRoof, new TaskInfo());//####[46]####
    }//####[46]####
    public TaskID<Void> buildSingleTask(Color colorWalls, BlockingQueue<Color> colorRoof, TaskInfo taskinfo) {//####[46]####
        // ensure Method variable is set//####[46]####
        if (__pt__buildSingleTask_Color_Color_method == null) {//####[46]####
            __pt__buildSingleTask_Color_Color_ensureMethodVarSet();//####[46]####
        }//####[46]####
        taskinfo.setQueueArgIndexes(1);//####[46]####
        taskinfo.setIsPipeline(true);//####[46]####
        taskinfo.setParameters(colorWalls, colorRoof);//####[46]####
        taskinfo.setMethod(__pt__buildSingleTask_Color_Color_method);//####[46]####
        taskinfo.setInstance(this);//####[46]####
        return TaskpoolFactory.getTaskpool().enqueue(taskinfo);//####[46]####
    }//####[46]####
    public TaskID<Void> buildSingleTask(TaskID<Color> colorWalls, BlockingQueue<Color> colorRoof) {//####[46]####
        //-- execute asynchronously by enqueuing onto the taskpool//####[46]####
        return buildSingleTask(colorWalls, colorRoof, new TaskInfo());//####[46]####
    }//####[46]####
    public TaskID<Void> buildSingleTask(TaskID<Color> colorWalls, BlockingQueue<Color> colorRoof, TaskInfo taskinfo) {//####[46]####
        // ensure Method variable is set//####[46]####
        if (__pt__buildSingleTask_Color_Color_method == null) {//####[46]####
            __pt__buildSingleTask_Color_Color_ensureMethodVarSet();//####[46]####
        }//####[46]####
        taskinfo.setQueueArgIndexes(1);//####[46]####
        taskinfo.setIsPipeline(true);//####[46]####
        taskinfo.setTaskIdArgIndexes(0);//####[46]####
        taskinfo.addDependsOn(colorWalls);//####[46]####
        taskinfo.setParameters(colorWalls, colorRoof);//####[46]####
        taskinfo.setMethod(__pt__buildSingleTask_Color_Color_method);//####[46]####
        taskinfo.setInstance(this);//####[46]####
        return TaskpoolFactory.getTaskpool().enqueue(taskinfo);//####[46]####
    }//####[46]####
    public TaskID<Void> buildSingleTask(BlockingQueue<Color> colorWalls, BlockingQueue<Color> colorRoof) {//####[46]####
        //-- execute asynchronously by enqueuing onto the taskpool//####[46]####
        return buildSingleTask(colorWalls, colorRoof, new TaskInfo());//####[46]####
    }//####[46]####
    public TaskID<Void> buildSingleTask(BlockingQueue<Color> colorWalls, BlockingQueue<Color> colorRoof, TaskInfo taskinfo) {//####[46]####
        // ensure Method variable is set//####[46]####
        if (__pt__buildSingleTask_Color_Color_method == null) {//####[46]####
            __pt__buildSingleTask_Color_Color_ensureMethodVarSet();//####[46]####
        }//####[46]####
        taskinfo.setQueueArgIndexes(0, 1);//####[46]####
        taskinfo.setIsPipeline(true);//####[46]####
        taskinfo.setParameters(colorWalls, colorRoof);//####[46]####
        taskinfo.setMethod(__pt__buildSingleTask_Color_Color_method);//####[46]####
        taskinfo.setInstance(this);//####[46]####
        return TaskpoolFactory.getTaskpool().enqueue(taskinfo);//####[46]####
    }//####[46]####
    public void __pt__buildSingleTask(Color colorWalls, Color colorRoof) {//####[46]####
        build(colorWalls, colorRoof);//####[47]####
    }//####[48]####
//####[48]####
//####[51]####
    public void build(Color colorWalls, Color colorRoof) {//####[51]####
        this.colorWalls = colorWalls;//####[52]####
        this.colorRoof = colorRoof;//####[53]####
        initialiseMaterial();//####[54]####
        buildAll(foundation);//####[56]####
        buildAll(wallSiding);//####[57]####
        buildAll(roofTiles);//####[58]####
        buildItem(door);//####[59]####
        buildAll(windows);//####[60]####
        buildItem(forSaleSign);//####[61]####
    }//####[62]####
//####[65]####
    private static volatile Method __pt__buildTask_Color_Color_method = null;//####[65]####
    private synchronized static void __pt__buildTask_Color_Color_ensureMethodVarSet() {//####[65]####
        if (__pt__buildTask_Color_Color_method == null) {//####[65]####
            try {//####[65]####
                __pt__buildTask_Color_Color_method = ParaTaskHelper.getDeclaredMethod(new ParaTaskHelper.ClassGetter().getCurrentClass(), "__pt__buildTask", new Class[] {//####[65]####
                    Color.class, Color.class//####[65]####
                });//####[65]####
            } catch (Exception e) {//####[65]####
                e.printStackTrace();//####[65]####
            }//####[65]####
        }//####[65]####
    }//####[65]####
    public TaskID<Void> buildTask(Color colorWalls, Color colorRoof) {//####[65]####
        //-- execute asynchronously by enqueuing onto the taskpool//####[65]####
        return buildTask(colorWalls, colorRoof, new TaskInfo());//####[65]####
    }//####[65]####
    public TaskID<Void> buildTask(Color colorWalls, Color colorRoof, TaskInfo taskinfo) {//####[65]####
        // ensure Method variable is set//####[65]####
        if (__pt__buildTask_Color_Color_method == null) {//####[65]####
            __pt__buildTask_Color_Color_ensureMethodVarSet();//####[65]####
        }//####[65]####
        taskinfo.setParameters(colorWalls, colorRoof);//####[65]####
        taskinfo.setMethod(__pt__buildTask_Color_Color_method);//####[65]####
        taskinfo.setInstance(this);//####[65]####
        return TaskpoolFactory.getTaskpool().enqueue(taskinfo);//####[65]####
    }//####[65]####
    public TaskID<Void> buildTask(TaskID<Color> colorWalls, Color colorRoof) {//####[65]####
        //-- execute asynchronously by enqueuing onto the taskpool//####[65]####
        return buildTask(colorWalls, colorRoof, new TaskInfo());//####[65]####
    }//####[65]####
    public TaskID<Void> buildTask(TaskID<Color> colorWalls, Color colorRoof, TaskInfo taskinfo) {//####[65]####
        // ensure Method variable is set//####[65]####
        if (__pt__buildTask_Color_Color_method == null) {//####[65]####
            __pt__buildTask_Color_Color_ensureMethodVarSet();//####[65]####
        }//####[65]####
        taskinfo.setTaskIdArgIndexes(0);//####[65]####
        taskinfo.addDependsOn(colorWalls);//####[65]####
        taskinfo.setParameters(colorWalls, colorRoof);//####[65]####
        taskinfo.setMethod(__pt__buildTask_Color_Color_method);//####[65]####
        taskinfo.setInstance(this);//####[65]####
        return TaskpoolFactory.getTaskpool().enqueue(taskinfo);//####[65]####
    }//####[65]####
    public TaskID<Void> buildTask(BlockingQueue<Color> colorWalls, Color colorRoof) {//####[65]####
        //-- execute asynchronously by enqueuing onto the taskpool//####[65]####
        return buildTask(colorWalls, colorRoof, new TaskInfo());//####[65]####
    }//####[65]####
    public TaskID<Void> buildTask(BlockingQueue<Color> colorWalls, Color colorRoof, TaskInfo taskinfo) {//####[65]####
        // ensure Method variable is set//####[65]####
        if (__pt__buildTask_Color_Color_method == null) {//####[65]####
            __pt__buildTask_Color_Color_ensureMethodVarSet();//####[65]####
        }//####[65]####
        taskinfo.setQueueArgIndexes(0);//####[65]####
        taskinfo.setIsPipeline(true);//####[65]####
        taskinfo.setParameters(colorWalls, colorRoof);//####[65]####
        taskinfo.setMethod(__pt__buildTask_Color_Color_method);//####[65]####
        taskinfo.setInstance(this);//####[65]####
        return TaskpoolFactory.getTaskpool().enqueue(taskinfo);//####[65]####
    }//####[65]####
    public TaskID<Void> buildTask(Color colorWalls, TaskID<Color> colorRoof) {//####[65]####
        //-- execute asynchronously by enqueuing onto the taskpool//####[65]####
        return buildTask(colorWalls, colorRoof, new TaskInfo());//####[65]####
    }//####[65]####
    public TaskID<Void> buildTask(Color colorWalls, TaskID<Color> colorRoof, TaskInfo taskinfo) {//####[65]####
        // ensure Method variable is set//####[65]####
        if (__pt__buildTask_Color_Color_method == null) {//####[65]####
            __pt__buildTask_Color_Color_ensureMethodVarSet();//####[65]####
        }//####[65]####
        taskinfo.setTaskIdArgIndexes(1);//####[65]####
        taskinfo.addDependsOn(colorRoof);//####[65]####
        taskinfo.setParameters(colorWalls, colorRoof);//####[65]####
        taskinfo.setMethod(__pt__buildTask_Color_Color_method);//####[65]####
        taskinfo.setInstance(this);//####[65]####
        return TaskpoolFactory.getTaskpool().enqueue(taskinfo);//####[65]####
    }//####[65]####
    public TaskID<Void> buildTask(TaskID<Color> colorWalls, TaskID<Color> colorRoof) {//####[65]####
        //-- execute asynchronously by enqueuing onto the taskpool//####[65]####
        return buildTask(colorWalls, colorRoof, new TaskInfo());//####[65]####
    }//####[65]####
    public TaskID<Void> buildTask(TaskID<Color> colorWalls, TaskID<Color> colorRoof, TaskInfo taskinfo) {//####[65]####
        // ensure Method variable is set//####[65]####
        if (__pt__buildTask_Color_Color_method == null) {//####[65]####
            __pt__buildTask_Color_Color_ensureMethodVarSet();//####[65]####
        }//####[65]####
        taskinfo.setTaskIdArgIndexes(0, 1);//####[65]####
        taskinfo.addDependsOn(colorWalls);//####[65]####
        taskinfo.addDependsOn(colorRoof);//####[65]####
        taskinfo.setParameters(colorWalls, colorRoof);//####[65]####
        taskinfo.setMethod(__pt__buildTask_Color_Color_method);//####[65]####
        taskinfo.setInstance(this);//####[65]####
        return TaskpoolFactory.getTaskpool().enqueue(taskinfo);//####[65]####
    }//####[65]####
    public TaskID<Void> buildTask(BlockingQueue<Color> colorWalls, TaskID<Color> colorRoof) {//####[65]####
        //-- execute asynchronously by enqueuing onto the taskpool//####[65]####
        return buildTask(colorWalls, colorRoof, new TaskInfo());//####[65]####
    }//####[65]####
    public TaskID<Void> buildTask(BlockingQueue<Color> colorWalls, TaskID<Color> colorRoof, TaskInfo taskinfo) {//####[65]####
        // ensure Method variable is set//####[65]####
        if (__pt__buildTask_Color_Color_method == null) {//####[65]####
            __pt__buildTask_Color_Color_ensureMethodVarSet();//####[65]####
        }//####[65]####
        taskinfo.setQueueArgIndexes(0);//####[65]####
        taskinfo.setIsPipeline(true);//####[65]####
        taskinfo.setTaskIdArgIndexes(1);//####[65]####
        taskinfo.addDependsOn(colorRoof);//####[65]####
        taskinfo.setParameters(colorWalls, colorRoof);//####[65]####
        taskinfo.setMethod(__pt__buildTask_Color_Color_method);//####[65]####
        taskinfo.setInstance(this);//####[65]####
        return TaskpoolFactory.getTaskpool().enqueue(taskinfo);//####[65]####
    }//####[65]####
    public TaskID<Void> buildTask(Color colorWalls, BlockingQueue<Color> colorRoof) {//####[65]####
        //-- execute asynchronously by enqueuing onto the taskpool//####[65]####
        return buildTask(colorWalls, colorRoof, new TaskInfo());//####[65]####
    }//####[65]####
    public TaskID<Void> buildTask(Color colorWalls, BlockingQueue<Color> colorRoof, TaskInfo taskinfo) {//####[65]####
        // ensure Method variable is set//####[65]####
        if (__pt__buildTask_Color_Color_method == null) {//####[65]####
            __pt__buildTask_Color_Color_ensureMethodVarSet();//####[65]####
        }//####[65]####
        taskinfo.setQueueArgIndexes(1);//####[65]####
        taskinfo.setIsPipeline(true);//####[65]####
        taskinfo.setParameters(colorWalls, colorRoof);//####[65]####
        taskinfo.setMethod(__pt__buildTask_Color_Color_method);//####[65]####
        taskinfo.setInstance(this);//####[65]####
        return TaskpoolFactory.getTaskpool().enqueue(taskinfo);//####[65]####
    }//####[65]####
    public TaskID<Void> buildTask(TaskID<Color> colorWalls, BlockingQueue<Color> colorRoof) {//####[65]####
        //-- execute asynchronously by enqueuing onto the taskpool//####[65]####
        return buildTask(colorWalls, colorRoof, new TaskInfo());//####[65]####
    }//####[65]####
    public TaskID<Void> buildTask(TaskID<Color> colorWalls, BlockingQueue<Color> colorRoof, TaskInfo taskinfo) {//####[65]####
        // ensure Method variable is set//####[65]####
        if (__pt__buildTask_Color_Color_method == null) {//####[65]####
            __pt__buildTask_Color_Color_ensureMethodVarSet();//####[65]####
        }//####[65]####
        taskinfo.setQueueArgIndexes(1);//####[65]####
        taskinfo.setIsPipeline(true);//####[65]####
        taskinfo.setTaskIdArgIndexes(0);//####[65]####
        taskinfo.addDependsOn(colorWalls);//####[65]####
        taskinfo.setParameters(colorWalls, colorRoof);//####[65]####
        taskinfo.setMethod(__pt__buildTask_Color_Color_method);//####[65]####
        taskinfo.setInstance(this);//####[65]####
        return TaskpoolFactory.getTaskpool().enqueue(taskinfo);//####[65]####
    }//####[65]####
    public TaskID<Void> buildTask(BlockingQueue<Color> colorWalls, BlockingQueue<Color> colorRoof) {//####[65]####
        //-- execute asynchronously by enqueuing onto the taskpool//####[65]####
        return buildTask(colorWalls, colorRoof, new TaskInfo());//####[65]####
    }//####[65]####
    public TaskID<Void> buildTask(BlockingQueue<Color> colorWalls, BlockingQueue<Color> colorRoof, TaskInfo taskinfo) {//####[65]####
        // ensure Method variable is set//####[65]####
        if (__pt__buildTask_Color_Color_method == null) {//####[65]####
            __pt__buildTask_Color_Color_ensureMethodVarSet();//####[65]####
        }//####[65]####
        taskinfo.setQueueArgIndexes(0, 1);//####[65]####
        taskinfo.setIsPipeline(true);//####[65]####
        taskinfo.setParameters(colorWalls, colorRoof);//####[65]####
        taskinfo.setMethod(__pt__buildTask_Color_Color_method);//####[65]####
        taskinfo.setInstance(this);//####[65]####
        return TaskpoolFactory.getTaskpool().enqueue(taskinfo);//####[65]####
    }//####[65]####
    public void __pt__buildTask(Color colorWalls, Color colorRoof) {//####[65]####
        this.colorWalls = colorWalls;//####[66]####
        this.colorRoof = colorRoof;//####[67]####
        initialiseMaterial();//####[68]####
        TaskID idFoundation = buildAllTask(foundation);//####[70]####
        TaskInfo __pt__idWalls = new TaskInfo();//####[71]####
//####[71]####
        /*  -- ParaTask dependsOn clause for 'idWalls' -- *///####[71]####
        __pt__idWalls.addDependsOn(idFoundation);//####[71]####
//####[71]####
        TaskID idWalls = buildAllTask(wallSiding, __pt__idWalls);//####[71]####
        TaskInfo __pt__idRoof = new TaskInfo();//####[72]####
//####[72]####
        /*  -- ParaTask dependsOn clause for 'idRoof' -- *///####[72]####
        __pt__idRoof.addDependsOn(idWalls);//####[72]####
//####[72]####
        TaskID idRoof = buildAllTask(roofTiles, __pt__idRoof);//####[72]####
        TaskInfo __pt__idDoor = new TaskInfo();//####[73]####
//####[73]####
        /*  -- ParaTask dependsOn clause for 'idDoor' -- *///####[73]####
        __pt__idDoor.addDependsOn(idWalls);//####[73]####
//####[73]####
        TaskID idDoor = buildItemTask(door, __pt__idDoor);//####[73]####
        TaskInfo __pt__idWindows = new TaskInfo();//####[74]####
//####[74]####
        /*  -- ParaTask dependsOn clause for 'idWindows' -- *///####[74]####
        __pt__idWindows.addDependsOn(idWalls);//####[74]####
//####[74]####
        TaskID idWindows = buildAllTask(windows, __pt__idWindows);//####[74]####
        TaskInfo __pt__idSign = new TaskInfo();//####[75]####
//####[75]####
        /*  -- ParaTask dependsOn clause for 'idSign' -- *///####[75]####
        __pt__idSign.addDependsOn(idRoof);//####[75]####
        __pt__idSign.addDependsOn(idDoor);//####[75]####
        __pt__idSign.addDependsOn(idWindows);//####[75]####
//####[75]####
        TaskID idSign = buildItemTask(forSaleSign, __pt__idSign);//####[75]####
        try {//####[77]####
            idSign.waitTillFinished();//####[78]####
        } catch (Exception e) {//####[79]####
            e.printStackTrace();//####[80]####
        }//####[81]####
    }//####[82]####
//####[82]####
//####[84]####
    private void buildItem(BuildingMaterial item) {//####[84]####
        if (!item.getAndSetVisible(true)) //####[85]####
        {//####[85]####
            simulateWork(N);//####[86]####
            repaint();//####[87]####
        }//####[88]####
    }//####[89]####
//####[91]####
    private static volatile Method __pt__buildItemTask_BuildingMaterial_method = null;//####[91]####
    private synchronized static void __pt__buildItemTask_BuildingMaterial_ensureMethodVarSet() {//####[91]####
        if (__pt__buildItemTask_BuildingMaterial_method == null) {//####[91]####
            try {//####[91]####
                __pt__buildItemTask_BuildingMaterial_method = ParaTaskHelper.getDeclaredMethod(new ParaTaskHelper.ClassGetter().getCurrentClass(), "__pt__buildItemTask", new Class[] {//####[91]####
                    BuildingMaterial.class//####[91]####
                });//####[91]####
            } catch (Exception e) {//####[91]####
                e.printStackTrace();//####[91]####
            }//####[91]####
        }//####[91]####
    }//####[91]####
    public TaskID<Void> buildItemTask(BuildingMaterial item) {//####[91]####
        //-- execute asynchronously by enqueuing onto the taskpool//####[91]####
        return buildItemTask(item, new TaskInfo());//####[91]####
    }//####[91]####
    public TaskID<Void> buildItemTask(BuildingMaterial item, TaskInfo taskinfo) {//####[91]####
        // ensure Method variable is set//####[91]####
        if (__pt__buildItemTask_BuildingMaterial_method == null) {//####[91]####
            __pt__buildItemTask_BuildingMaterial_ensureMethodVarSet();//####[91]####
        }//####[91]####
        taskinfo.setParameters(item);//####[91]####
        taskinfo.setMethod(__pt__buildItemTask_BuildingMaterial_method);//####[91]####
        taskinfo.setInstance(this);//####[91]####
        return TaskpoolFactory.getTaskpool().enqueue(taskinfo);//####[91]####
    }//####[91]####
    public TaskID<Void> buildItemTask(TaskID<BuildingMaterial> item) {//####[91]####
        //-- execute asynchronously by enqueuing onto the taskpool//####[91]####
        return buildItemTask(item, new TaskInfo());//####[91]####
    }//####[91]####
    public TaskID<Void> buildItemTask(TaskID<BuildingMaterial> item, TaskInfo taskinfo) {//####[91]####
        // ensure Method variable is set//####[91]####
        if (__pt__buildItemTask_BuildingMaterial_method == null) {//####[91]####
            __pt__buildItemTask_BuildingMaterial_ensureMethodVarSet();//####[91]####
        }//####[91]####
        taskinfo.setTaskIdArgIndexes(0);//####[91]####
        taskinfo.addDependsOn(item);//####[91]####
        taskinfo.setParameters(item);//####[91]####
        taskinfo.setMethod(__pt__buildItemTask_BuildingMaterial_method);//####[91]####
        taskinfo.setInstance(this);//####[91]####
        return TaskpoolFactory.getTaskpool().enqueue(taskinfo);//####[91]####
    }//####[91]####
    public TaskID<Void> buildItemTask(BlockingQueue<BuildingMaterial> item) {//####[91]####
        //-- execute asynchronously by enqueuing onto the taskpool//####[91]####
        return buildItemTask(item, new TaskInfo());//####[91]####
    }//####[91]####
    public TaskID<Void> buildItemTask(BlockingQueue<BuildingMaterial> item, TaskInfo taskinfo) {//####[91]####
        // ensure Method variable is set//####[91]####
        if (__pt__buildItemTask_BuildingMaterial_method == null) {//####[91]####
            __pt__buildItemTask_BuildingMaterial_ensureMethodVarSet();//####[91]####
        }//####[91]####
        taskinfo.setQueueArgIndexes(0);//####[91]####
        taskinfo.setIsPipeline(true);//####[91]####
        taskinfo.setParameters(item);//####[91]####
        taskinfo.setMethod(__pt__buildItemTask_BuildingMaterial_method);//####[91]####
        taskinfo.setInstance(this);//####[91]####
        return TaskpoolFactory.getTaskpool().enqueue(taskinfo);//####[91]####
    }//####[91]####
    public void __pt__buildItemTask(BuildingMaterial item) {//####[91]####
        buildItem(item);//####[92]####
    }//####[93]####
//####[93]####
//####[95]####
    private static volatile Method __pt__buildAllTask_ListBuildingMaterial_method = null;//####[95]####
    private synchronized static void __pt__buildAllTask_ListBuildingMaterial_ensureMethodVarSet() {//####[95]####
        if (__pt__buildAllTask_ListBuildingMaterial_method == null) {//####[95]####
            try {//####[95]####
                __pt__buildAllTask_ListBuildingMaterial_method = ParaTaskHelper.getDeclaredMethod(new ParaTaskHelper.ClassGetter().getCurrentClass(), "__pt__buildAllTask", new Class[] {//####[95]####
                    List.class//####[95]####
                });//####[95]####
            } catch (Exception e) {//####[95]####
                e.printStackTrace();//####[95]####
            }//####[95]####
        }//####[95]####
    }//####[95]####
    public TaskIDGroup<Void> buildAllTask(List<BuildingMaterial> items) {//####[95]####
        //-- execute asynchronously by enqueuing onto the taskpool//####[95]####
        return buildAllTask(items, new TaskInfo());//####[95]####
    }//####[95]####
    public TaskIDGroup<Void> buildAllTask(List<BuildingMaterial> items, TaskInfo taskinfo) {//####[95]####
        // ensure Method variable is set//####[95]####
        if (__pt__buildAllTask_ListBuildingMaterial_method == null) {//####[95]####
            __pt__buildAllTask_ListBuildingMaterial_ensureMethodVarSet();//####[95]####
        }//####[95]####
        taskinfo.setParameters(items);//####[95]####
        taskinfo.setMethod(__pt__buildAllTask_ListBuildingMaterial_method);//####[95]####
        taskinfo.setInstance(this);//####[95]####
        return TaskpoolFactory.getTaskpool().enqueueMulti(taskinfo, -1);//####[95]####
    }//####[95]####
    public TaskIDGroup<Void> buildAllTask(TaskID<List<BuildingMaterial>> items) {//####[95]####
        //-- execute asynchronously by enqueuing onto the taskpool//####[95]####
        return buildAllTask(items, new TaskInfo());//####[95]####
    }//####[95]####
    public TaskIDGroup<Void> buildAllTask(TaskID<List<BuildingMaterial>> items, TaskInfo taskinfo) {//####[95]####
        // ensure Method variable is set//####[95]####
        if (__pt__buildAllTask_ListBuildingMaterial_method == null) {//####[95]####
            __pt__buildAllTask_ListBuildingMaterial_ensureMethodVarSet();//####[95]####
        }//####[95]####
        taskinfo.setTaskIdArgIndexes(0);//####[95]####
        taskinfo.addDependsOn(items);//####[95]####
        taskinfo.setParameters(items);//####[95]####
        taskinfo.setMethod(__pt__buildAllTask_ListBuildingMaterial_method);//####[95]####
        taskinfo.setInstance(this);//####[95]####
        return TaskpoolFactory.getTaskpool().enqueueMulti(taskinfo, -1);//####[95]####
    }//####[95]####
    public TaskIDGroup<Void> buildAllTask(BlockingQueue<List<BuildingMaterial>> items) {//####[95]####
        //-- execute asynchronously by enqueuing onto the taskpool//####[95]####
        return buildAllTask(items, new TaskInfo());//####[95]####
    }//####[95]####
    public TaskIDGroup<Void> buildAllTask(BlockingQueue<List<BuildingMaterial>> items, TaskInfo taskinfo) {//####[95]####
        // ensure Method variable is set//####[95]####
        if (__pt__buildAllTask_ListBuildingMaterial_method == null) {//####[95]####
            __pt__buildAllTask_ListBuildingMaterial_ensureMethodVarSet();//####[95]####
        }//####[95]####
        taskinfo.setQueueArgIndexes(0);//####[95]####
        taskinfo.setIsPipeline(true);//####[95]####
        taskinfo.setParameters(items);//####[95]####
        taskinfo.setMethod(__pt__buildAllTask_ListBuildingMaterial_method);//####[95]####
        taskinfo.setInstance(this);//####[95]####
        return TaskpoolFactory.getTaskpool().enqueueMulti(taskinfo, -1);//####[95]####
    }//####[95]####
    public void __pt__buildAllTask(List<BuildingMaterial> items) {//####[95]####
        buildAll(items);//####[96]####
    }//####[97]####
//####[97]####
//####[99]####
    private void buildAll(List<BuildingMaterial> items) {//####[99]####
        Iterator<BuildingMaterial> it = items.iterator();//####[100]####
        while (it.hasNext()) //####[101]####
        {//####[101]####
            buildItem(it.next());//####[102]####
        }//####[103]####
    }//####[104]####
//####[106]####
    public void update(Graphics g) {//####[106]####
        paint(g);//####[107]####
    }//####[108]####
//####[110]####
    public void paint(Graphics g) {//####[110]####
        if (clearScreen) //####[112]####
        {//####[112]####
            g.clearRect(0, 0, width, height);//####[113]####
            clearScreen = false;//####[114]####
        }//####[115]####
        for (BuildingMaterial b : foundation) //####[118]####
        {//####[118]####
            if (b.isVisible()) //####[119]####
            {//####[119]####
                g.setColor(new Color(162, 158, 24));//####[120]####
                g.fillRect(b.getX(), b.getY(), b.getWidth(), b.getHeight());//####[121]####
                g.setColor(Color.BLACK);//####[122]####
                g.drawRect(b.getX(), b.getY(), b.getWidth(), b.getHeight());//####[123]####
            }//####[124]####
        }//####[125]####
        for (BuildingMaterial b : wallSiding) //####[128]####
        {//####[128]####
            if (b.isVisible()) //####[130]####
            {//####[130]####
                g.setColor(colorWalls);//####[131]####
                g.fillRect(b.getX(), b.getY(), b.getWidth(), b.getHeight());//####[132]####
                g.setColor(Color.BLACK);//####[133]####
                g.drawRect(b.getX(), b.getY(), b.getWidth(), b.getHeight());//####[134]####
            }//####[135]####
        }//####[136]####
        for (BuildingMaterial b : roofTiles) //####[139]####
        {//####[139]####
            if (b.isVisible()) //####[141]####
            {//####[141]####
                g.setColor(colorRoof);//####[142]####
                g.fillRect(b.getX(), b.getY(), b.getWidth(), b.getHeight());//####[143]####
                g.setColor(Color.BLACK);//####[144]####
                g.drawRect(b.getX(), b.getY(), b.getWidth(), b.getHeight());//####[145]####
            }//####[146]####
        }//####[147]####
        if (door.isVisible()) //####[150]####
        {//####[150]####
            g.setColor(new Color(152, 118, 84));//####[151]####
            g.fillRect(door.getX(), door.getY(), door.getWidth(), door.getHeight());//####[152]####
            g.setColor(Color.BLACK);//####[153]####
            g.drawRect(door.getX(), door.getY(), door.getWidth(), door.getHeight());//####[154]####
        }//####[155]####
        for (BuildingMaterial b : windows) //####[158]####
        {//####[158]####
            if (b.isVisible()) //####[159]####
            {//####[159]####
                g.setColor(new Color(173, 216, 230));//####[160]####
                g.fillRect(b.getX(), b.getY(), b.getWidth(), b.getHeight());//####[161]####
                g.setColor(Color.BLACK);//####[162]####
                g.drawRect(b.getX(), b.getY(), b.getWidth(), b.getHeight());//####[163]####
            }//####[164]####
        }//####[165]####
        if (forSaleSign.isVisible()) //####[168]####
        {//####[168]####
            g.setColor(new Color(152, 118, 84));//####[169]####
            g.fillRect(400, 260, 15, 20);//####[170]####
            g.fillRect(445, 260, 15, 20);//####[171]####
            g.setColor(Color.BLACK);//####[172]####
            g.drawRect(400, 260, 15, 20);//####[173]####
            g.drawRect(445, 260, 15, 20);//####[174]####
            g.setColor(new Color(255, 239, 0));//####[176]####
            g.fillRect(forSaleSign.getX(), forSaleSign.getY(), forSaleSign.getWidth(), forSaleSign.getHeight());//####[177]####
            g.setColor(Color.BLACK);//####[178]####
            g.drawRect(forSaleSign.getX(), forSaleSign.getY(), forSaleSign.getWidth(), forSaleSign.getHeight());//####[179]####
            Font f = g.getFont();//####[181]####
            g.setFont(new Font(f.getName(), Font.BOLD, 21));//####[182]####
            g.drawString("For", forSaleSign.getX() + 30, forSaleSign.getY() + 30);//####[183]####
            g.drawString("Sale", forSaleSign.getX() + 25, forSaleSign.getY() + 60);//####[184]####
        }//####[185]####
    }//####[186]####
//####[188]####
    private void initFoundation() {//####[188]####
        int numCols = 31;//####[190]####
        int w = 15;//####[191]####
        int h = 10;//####[192]####
        int x = 20;//####[194]####
        int y = 280;//####[195]####
        for (int i = 0; i < numCols; i++) //####[196]####
        foundation.add(new BuildingMaterial(x + i * w, y, w, h, false));//####[197]####
        x -= 7;//####[199]####
        y += h;//####[200]####
        for (int i = 0; i < numCols; i++) //####[201]####
        foundation.add(new BuildingMaterial(x + i * w, y, w, h, false));//####[202]####
        x += 7;//####[204]####
        y += h;//####[205]####
        for (int i = 0; i < numCols; i++) //####[206]####
        foundation.add(new BuildingMaterial(x + i * w, y, w, h, false));//####[207]####
        List<BuildingMaterial> list = new ArrayList<BuildingMaterial>();//####[209]####
        list.addAll(foundation);//####[210]####
        Collections.shuffle(list);//####[211]####
        foundation.clear();//####[212]####
        foundation.addAll(list);//####[213]####
    }//####[214]####
//####[216]####
    private void initWallSiding() {//####[216]####
        int numPlanks = 40;//####[217]####
        int totalW = 320;//####[218]####
        int w = totalW / numPlanks;//####[219]####
        int h = 150;//####[220]####
        int x = 40;//####[222]####
        int y = 130;//####[223]####
        for (int i = 0; i < numPlanks; i++) //####[224]####
        wallSiding.add(new BuildingMaterial(x + i * w, y, w, h, false));//####[225]####
        List<BuildingMaterial> list = new ArrayList<BuildingMaterial>();//####[228]####
        list.addAll(wallSiding);//####[229]####
        Collections.shuffle(list);//####[230]####
        wallSiding.clear();//####[231]####
        wallSiding.addAll(list);//####[232]####
    }//####[234]####
//####[236]####
    private void initRoofTiles() {//####[236]####
        int numPlanks = 12;//####[237]####
        int dec = 10;//####[238]####
        int h = 10;//####[239]####
        int w = 360;//####[240]####
        int x = 20;//####[242]####
        int y = 130 - h;//####[243]####
        for (int i = 0; i < numPlanks; i++) //####[244]####
        {//####[244]####
            roofTiles.add(new BuildingMaterial(x + i * dec, y - i * h, w, h, false));//####[245]####
            w -= 2 * dec;//####[246]####
        }//####[247]####
        List<BuildingMaterial> list = new ArrayList<BuildingMaterial>();//####[250]####
        list.addAll(roofTiles);//####[251]####
        Collections.shuffle(list);//####[252]####
        roofTiles.clear();//####[253]####
        roofTiles.addAll(list);//####[254]####
    }//####[255]####
//####[257]####
    private void initWindowsAndDoor() {//####[257]####
        door = new BuildingMaterial(63, 160, 75, 120, false);//####[258]####
        windows.add(new BuildingMaterial(160, 160, 80, 60, false));//####[260]####
        windows.add(new BuildingMaterial(253, 160, 75, 60, false));//####[261]####
    }//####[262]####
//####[264]####
    private void initForSaleSign() {//####[264]####
        forSaleSign = new BuildingMaterial(380, 180, 100, 80, false);//####[265]####
    }//####[266]####
//####[268]####
    public void setComputationLevel(int N) {//####[268]####
        this.N = N;//####[269]####
    }//####[270]####
//####[272]####
    public void reset() {//####[272]####
        clearScreen = true;//####[273]####
        for (BuildingMaterial b : foundation) //####[275]####
        {//####[275]####
            b.getAndSetVisible(false);//####[276]####
        }//####[277]####
        for (BuildingMaterial b : wallSiding) //####[279]####
        {//####[279]####
            b.getAndSetVisible(false);//####[280]####
        }//####[281]####
        for (BuildingMaterial b : roofTiles) //####[283]####
        {//####[283]####
            b.getAndSetVisible(false);//####[284]####
        }//####[285]####
        door.getAndSetVisible(false);//####[287]####
        for (BuildingMaterial b : windows) //####[289]####
        {//####[289]####
            b.getAndSetVisible(false);//####[290]####
        }//####[291]####
        forSaleSign.getAndSetVisible(false);//####[293]####
        repaint();//####[294]####
    }//####[295]####
//####[297]####
    private void simulateWork(int N) {//####[297]####
        double xmin = -1.0;//####[298]####
        double ymin = -1.0;//####[299]####
        double width = 2.0;//####[300]####
        double height = 2.0;//####[301]####
        for (int i = 0; i < N; i++) //####[302]####
        {//####[302]####
            for (int j = 0; j < N; j++) //####[303]####
            {//####[303]####
                double x = xmin + i * width / N;//####[304]####
                double y = ymin + j * height / N;//####[305]####
                Complex z = new Complex(x, y);//####[306]####
                newton(z);//####[307]####
            }//####[308]####
        }//####[309]####
    }//####[310]####
//####[312]####
    private Color newton(Complex z) {//####[312]####
        double EPSILON = 0.00000001;//####[313]####
        Complex four = new Complex(4, 0);//####[314]####
        Complex one = new Complex(1, 0);//####[315]####
        Complex root1 = new Complex(1, 0);//####[316]####
        Complex root2 = new Complex(-1, 0);//####[317]####
        Complex root3 = new Complex(0, 1);//####[318]####
        Complex root4 = new Complex(0, -1);//####[319]####
        for (int i = 0; i < 100; i++) //####[320]####
        {//####[320]####
            Complex f = z.times(z).times(z).times(z).minus(one);//####[321]####
            Complex fp = four.times(z).times(z).times(z);//####[322]####
            z = z.minus(f.divides(fp));//####[323]####
            if (z.minus(root1).abs() <= EPSILON) //####[324]####
            return Color.WHITE;//####[324]####
            if (z.minus(root2).abs() <= EPSILON) //####[325]####
            return Color.RED;//####[325]####
            if (z.minus(root3).abs() <= EPSILON) //####[326]####
            return Color.GREEN;//####[326]####
            if (z.minus(root4).abs() <= EPSILON) //####[327]####
            return Color.BLUE;//####[327]####
        }//####[328]####
        return Color.BLACK;//####[329]####
    }//####[330]####
//####[332]####
    public void initialiseMaterial() {//####[332]####
        foundation = new CopyOnWriteArrayList<BuildingMaterial>();//####[333]####
        wallSiding = new CopyOnWriteArrayList<BuildingMaterial>();//####[334]####
        roofTiles = new CopyOnWriteArrayList<BuildingMaterial>();//####[335]####
        windows = new CopyOnWriteArrayList<BuildingMaterial>();//####[336]####
        initFoundation();//####[338]####
        initWallSiding();//####[339]####
        initRoofTiles();//####[340]####
        initWindowsAndDoor();//####[341]####
        initForSaleSign();//####[342]####
    }//####[343]####
}//####[343]####
