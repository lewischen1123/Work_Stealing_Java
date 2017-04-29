package house;//####[1]####
//####[1]####
import java.awt.BorderLayout;//####[3]####
import java.awt.Color;//####[4]####
import java.awt.Dimension;//####[5]####
import java.awt.Font;//####[6]####
import java.awt.GridLayout;//####[7]####
import java.awt.Toolkit;//####[8]####
import java.awt.event.ActionEvent;//####[9]####
import java.awt.event.ActionListener;//####[10]####
import javax.swing.ButtonGroup;//####[12]####
import javax.swing.JButton;//####[13]####
import javax.swing.JColorChooser;//####[14]####
import javax.swing.JFrame;//####[15]####
import javax.swing.JLabel;//####[16]####
import javax.swing.JMenu;//####[17]####
import javax.swing.JMenuBar;//####[18]####
import javax.swing.JPanel;//####[19]####
import javax.swing.JRadioButtonMenuItem;//####[20]####
//####[20]####
//-- ParaTask related imports//####[20]####
import pt.runtime.*;//####[20]####
import java.util.concurrent.ExecutionException;//####[20]####
import java.util.concurrent.locks.*;//####[20]####
import java.lang.reflect.*;//####[20]####
import pt.runtime.GuiThread;//####[20]####
import java.util.concurrent.BlockingQueue;//####[20]####
import java.util.ArrayList;//####[20]####
import java.util.List;//####[20]####
//####[20]####
public class Build extends JFrame implements ActionListener {//####[22]####
    static{ParaTask.init();}//####[22]####
    /*  ParaTask helper method to access private/protected slots *///####[22]####
    public void __pt__accessPrivateSlot(Method m, Object instance, TaskID arg, Object interResult ) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {//####[22]####
        if (m.getParameterTypes().length == 0)//####[22]####
            m.invoke(instance);//####[22]####
        else if ((m.getParameterTypes().length == 1))//####[22]####
            m.invoke(instance, arg);//####[22]####
        else //####[22]####
            m.invoke(instance, arg, interResult);//####[22]####
    }//####[22]####
//####[24]####
    private String sequential = "Uh oh! This is sequential (click to change)";//####[24]####
//####[25]####
    private String concurrent = "Better... This is concurrent (click to change)";//####[25]####
//####[26]####
    private String parallel = "Great! This is parallel (click to change)";//####[26]####
//####[28]####
    private long startTime;//####[28]####
//####[30]####
    private JButton btnBuild;//####[30]####
//####[31]####
    private JButton btnCancel;//####[31]####
//####[32]####
    private JButton btnParSeq;//####[32]####
//####[34]####
    private String currentJob;//####[34]####
//####[36]####
    private JRadioButtonMenuItem level_1 = new JRadioButtonMenuItem("Low");//####[36]####
//####[37]####
    private JRadioButtonMenuItem level_2 = new JRadioButtonMenuItem("Medium");//####[37]####
//####[38]####
    private JRadioButtonMenuItem level_3 = new JRadioButtonMenuItem("High");//####[38]####
//####[40]####
    private JButton btnRoof;//####[40]####
//####[41]####
    private JButton btnWalls;//####[41]####
//####[42]####
    private Color colorRoof = Color.BLUE;//####[42]####
//####[43]####
    private Color colorWalls = Color.YELLOW;//####[43]####
//####[45]####
    private House houseApplet;//####[45]####
//####[47]####
    public Build(String name) {//####[47]####
        super(name);//####[48]####
        createGUI();//####[49]####
    }//####[50]####
//####[52]####
    private void finishedBuilding() {//####[52]####
        btnBuild.setEnabled(true);//####[53]####
        long time = System.currentTimeMillis() - startTime;//####[54]####
        System.out.println(currentJob + " time: " + time + " ms");//####[55]####
    }//####[56]####
//####[58]####
    public void actionPerformed(ActionEvent e) {//####[58]####
        if (level_1.isSelected()) //####[59]####
        houseApplet.setComputationLevel(10); else if (level_2.isSelected()) //####[61]####
        houseApplet.setComputationLevel(28); else if (level_3.isSelected()) //####[63]####
        houseApplet.setComputationLevel(50);//####[64]####
        btnBuild.setEnabled(false);//####[66]####
        houseApplet.reset();//####[67]####
        startTime = System.currentTimeMillis();//####[68]####
        if (btnParSeq.getText().equals(sequential)) //####[70]####
        {//####[70]####
            currentJob = "Sequential";//####[71]####
            houseApplet.build(colorWalls, colorRoof);//####[72]####
            finishedBuilding();//####[73]####
        } else if (btnParSeq.getText().equals(concurrent)) //####[75]####
        {//####[75]####
            currentJob = "Concurrent";//####[76]####
            TaskInfo __pt__id = new TaskInfo();//####[77]####
//####[77]####
            boolean isEDT = GuiThread.isEventDispatchThread();//####[77]####
//####[77]####
//####[77]####
            /*  -- ParaTask notify clause for 'id' -- *///####[77]####
            try {//####[77]####
                Method __pt__id_slot_0 = null;//####[77]####
                __pt__id_slot_0 = ParaTaskHelper.getDeclaredMethod(getClass(), "finishedBuilding", new Class[] {});//####[77]####
                if (false) finishedBuilding(); //-- ParaTask uses this dummy statement to ensure the slot exists (otherwise Java compiler will complain)//####[77]####
                __pt__id.addSlotToNotify(new Slot(__pt__id_slot_0, this, false));//####[77]####
//####[77]####
            } catch(Exception __pt__e) { //####[77]####
                System.err.println("Problem registering method in clause:");//####[77]####
                __pt__e.printStackTrace();//####[77]####
            }//####[77]####
            TaskID id = houseApplet.buildSingleTask(colorWalls, colorRoof, __pt__id);//####[77]####
        } else {//####[79]####
            currentJob = "Parallel";//####[80]####
            TaskInfo __pt__id = new TaskInfo();//####[81]####
//####[81]####
            boolean isEDT = GuiThread.isEventDispatchThread();//####[81]####
//####[81]####
//####[81]####
            /*  -- ParaTask notify clause for 'id' -- *///####[81]####
            try {//####[81]####
                Method __pt__id_slot_0 = null;//####[81]####
                __pt__id_slot_0 = ParaTaskHelper.getDeclaredMethod(getClass(), "finishedBuilding", new Class[] {});//####[81]####
                if (false) finishedBuilding(); //-- ParaTask uses this dummy statement to ensure the slot exists (otherwise Java compiler will complain)//####[81]####
                __pt__id.addSlotToNotify(new Slot(__pt__id_slot_0, this, false));//####[81]####
//####[81]####
            } catch(Exception __pt__e) { //####[81]####
                System.err.println("Problem registering method in clause:");//####[81]####
                __pt__e.printStackTrace();//####[81]####
            }//####[81]####
            TaskID id = houseApplet.buildTask(colorWalls, colorRoof, __pt__id);//####[81]####
        }//####[82]####
    }//####[83]####
//####[85]####
    private void createGUI() {//####[85]####
        JMenuBar menuBar = new JMenuBar();//####[88]####
        JMenu menu = new JMenu("Computation Level");//####[89]####
        ButtonGroup levelGroup = new ButtonGroup();//####[91]####
        level_2.setSelected(true);//####[92]####
        levelGroup.add(level_1);//####[93]####
        levelGroup.add(level_2);//####[94]####
        levelGroup.add(level_3);//####[95]####
        menu.add(level_1);//####[97]####
        menu.add(level_2);//####[98]####
        menu.add(level_3);//####[99]####
        menuBar.add(menu);//####[100]####
        setJMenuBar(menuBar);//####[102]####
        int width = 200;//####[105]####
        int height = 80;//####[106]####
        btnRoof = new JButton("Select...");//####[108]####
        btnRoof.addActionListener(new ActionListener() {//####[108]####
//####[111]####
            @Override//####[111]####
            public void actionPerformed(ActionEvent e) {//####[111]####
                Color c = JColorChooser.showDialog(Build.this, "Select a colour for the roof", colorRoof);//####[112]####
                if (c != null) //####[113]####
                {//####[113]####
                    colorRoof = c;//####[114]####
                    btnRoof.setBackground(c);//####[115]####
                }//####[116]####
            }//####[117]####
        });//####[117]####
        btnWalls = new JButton("Select...");//####[119]####
        btnWalls.addActionListener(new ActionListener() {//####[119]####
//####[122]####
            @Override//####[122]####
            public void actionPerformed(ActionEvent e) {//####[122]####
                Color c = JColorChooser.showDialog(Build.this, "Select a colour for the walls", colorWalls);//####[123]####
                if (c != null) //####[124]####
                {//####[124]####
                    colorWalls = c;//####[125]####
                    btnWalls.setBackground(c);//####[126]####
                }//####[127]####
            }//####[128]####
        });//####[128]####
        btnBuild = new JButton("Build!");//####[130]####
        btnBuild.setPreferredSize(new Dimension(width, height));//####[131]####
        btnBuild.addActionListener(this);//####[132]####
        btnCancel = new JButton("Clear");//####[134]####
        btnCancel.setPreferredSize(new Dimension(width, height));//####[135]####
        btnCancel.addActionListener(new ActionListener() {//####[135]####
//####[138]####
            @Override//####[138]####
            public void actionPerformed(ActionEvent arg0) {//####[138]####
                houseApplet.reset();//####[139]####
            }//####[140]####
        });//####[140]####
        JPanel panelRoof = new JPanel(new GridLayout(1, 2));//####[143]####
        panelRoof.add(new JLabel("Roof color:", JLabel.CENTER));//####[144]####
        btnRoof.setBackground(colorRoof);//####[145]####
        panelRoof.add(btnRoof);//####[146]####
        panelRoof.setPreferredSize(new Dimension(width, height));//####[147]####
        JPanel panelWalls = new JPanel(new GridLayout(1, 2));//####[149]####
        panelWalls.add(new JLabel("Wall color:", JLabel.CENTER));//####[150]####
        btnWalls.setBackground(colorWalls);//####[151]####
        panelWalls.add(btnWalls);//####[152]####
        panelWalls.setPreferredSize(new Dimension(width, height));//####[153]####
        JPanel panelLeft = new JPanel();//####[155]####
        panelLeft.setLayout(new GridLayout(4, 1));//####[156]####
        panelLeft.add(panelRoof);//####[157]####
        panelLeft.add(panelWalls);//####[158]####
        panelLeft.add(btnBuild);//####[159]####
        panelLeft.add(btnCancel);//####[160]####
        getContentPane().add(panelLeft, BorderLayout.WEST);//####[162]####
        btnParSeq = new JButton(sequential);//####[169]####
        btnParSeq.setBackground(Color.red);//####[170]####
        Font f = btnParSeq.getFont();//####[172]####
        btnParSeq.setFont(new Font(f.getName(), Font.BOLD, 25));//####[173]####
        btnParSeq.addActionListener(new ActionListener() {//####[173]####
//####[176]####
            @Override//####[176]####
            public void actionPerformed(ActionEvent arg0) {//####[176]####
                if (btnParSeq.getText().equals(sequential)) //####[178]####
                {//####[178]####
                    btnParSeq.setText(concurrent);//####[179]####
                    btnParSeq.setBackground(Color.orange);//####[180]####
                } else if (btnParSeq.getText().equals(concurrent)) //####[181]####
                {//####[181]####
                    btnParSeq.setText(parallel);//####[182]####
                    btnParSeq.setBackground(Color.green);//####[183]####
                } else {//####[184]####
                    btnParSeq.setText(sequential);//####[185]####
                    btnParSeq.setBackground(Color.red);//####[186]####
                }//####[187]####
            }//####[188]####
        });//####[188]####
        btnParSeq.setPreferredSize(new Dimension(width, height));//####[190]####
        getContentPane().add(btnParSeq, BorderLayout.SOUTH);//####[191]####
        Toolkit tk = Toolkit.getDefaultToolkit();//####[194]####
        Dimension screenSize = tk.getScreenSize();//####[195]####
        int screenHeight = screenSize.height;//####[196]####
        int screenWidth = screenSize.width;//####[197]####
        setLocation(screenWidth / 4, screenHeight / 4);//####[198]####
        houseApplet = new House(this);//####[200]####
        getContentPane().add(houseApplet, BorderLayout.CENTER);//####[201]####
    }//####[202]####
//####[204]####
    public static void main(String[] args) {//####[204]####
        ParaTask.init();//####[205]####
        Build app = new Build("Build a house");//####[206]####
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//####[207]####
        app.setResizable(false);//####[208]####
        app.pack();//####[209]####
        app.setVisible(true);//####[210]####
    }//####[211]####
}//####[211]####
