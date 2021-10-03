/*
 * ProbTSPJFrame.java
 *
 * Created on 4 de agosto de 2005, 23:18
 */
package IA.TSP2;

import java.util.List;

import aima.search.framework.Problem;
import aima.search.framework.Search;
import aima.search.framework.SearchAgent;
import aima.search.informed.HillClimbingSearch;
import aima.search.informed.SimulatedAnnealingSearch;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.NumberFormatter;
import javax.swing.text.DefaultFormatterFactory;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JFrame;
import org.jfree.data.xy.XYSeries;

/**
 *
 * @author  javier
 */
public class ProbTSPJFrame extends javax.swing.JFrame {

    /**
     *
     */
    private static final long serialVersionUID = -8877491224336005353L;
    private int nc;
    private Search HC = null;
    private Search SA = null;
    private ProbTSPBoard inicial; 

    /** Creates new form ProbTSPJFrame */
    public ProbTSPJFrame() {


        numForm = DecimalFormat.getInstance();
        numForm.setParseIntegerOnly(true);
        numForm.setGroupingUsed(false);
        nfor = new NumberFormatter(numForm);
        nfor.setAllowsInvalid(false);
        formSeed = new DefaultFormatterFactory(nfor, nfor, nfor);


        numForm = DecimalFormat.getNumberInstance();
        numForm.setParseIntegerOnly(false);
        ((DecimalFormat) numForm).applyPattern("#####.#######");
        ((DecimalFormat) numForm).setDecimalSeparatorAlwaysShown(true);
        numForm.setGroupingUsed(false);
        nfor = new NumberFormatter(numForm);
        nfor.setAllowsInvalid(false);
        formLambda = new DefaultFormatterFactory(nfor, nfor, nfor);

        initComponents();

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        HillClimbingL = new javax.swing.JLabel();
        AnnealingL = new javax.swing.JLabel();
        hillClimbTA = new IA.TSP2.TSPDrawPanel();
        Inicial = new IA.TSP2.TSPDrawPanel();
        jPanel1 = new javax.swing.JPanel();
        CiudadesS = new javax.swing.JSlider();
        ciudadesL = new java.awt.Label();
        jPanel2 = new javax.swing.JPanel();
        ejecutarB = new javax.swing.JButton();
        ejecutarPrB = new javax.swing.JButton();
        SemillaL = new javax.swing.JLabel();
        SemillaTF = new javax.swing.JFormattedTextField(new Integer(1));
        jPanel3 = new javax.swing.JPanel();
        NiterL = new javax.swing.JLabel();
        ParKL = new javax.swing.JLabel();
        LambdaFT = new javax.swing.JFormattedTextField();
        LambdaL = new javax.swing.JLabel();
        AnnealingPL = new javax.swing.JLabel();
        KValue = new javax.swing.JFormattedTextField();
        nIt = new javax.swing.JFormattedTextField();
        annealingTA = new IA.TSP2.TSPDrawPanel();
        tfHC = new javax.swing.JTextField();
        tfSA = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jcbAnimacion = new javax.swing.JCheckBox();
        tfIni = new javax.swing.JTextField();
        jcbEstadoInicial = new javax.swing.JComboBox();
        jMenuBar18 = new javax.swing.JMenuBar();
        jMenu18 = new javax.swing.JMenu();
        Salir17 = new javax.swing.JMenuItem();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Travelling Salesman Problem");

        HillClimbingL.setText("Hill Climbing");

        AnnealingL.setText("Simulated Annealing");

        hillClimbTA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hillClimbTAMouseClicked(evt);
            }
        });

        jPanel1.setBorder(null);

        CiudadesS.setMajorTickSpacing(5);
        CiudadesS.setMinimum(10);
        CiudadesS.setMinorTickSpacing(5);
        CiudadesS.setPaintLabels(true);
        CiudadesS.setPaintTicks(true);
        CiudadesS.setSnapToTicks(true);
        CiudadesS.setToolTipText("Elige el n�mero de ciudades");
        CiudadesS.setValue(10);

        ciudadesL.setText("Num Ciudades:");

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(ciudadesL, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(CiudadesS, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(25, 25, 25)
                        .add(ciudadesL, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .add(CiudadesS, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        ejecutarB.setText("Ejecutar Prob Aleatorio");
        ejecutarB.setActionCommand(" Ejecutar");
        ejecutarB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ejecutarBMousePressed(evt);
            }
        });

        ejecutarPrB.setText("Ejecutar Prob Espec�fico");
        ejecutarPrB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ejecutarPrBActionPerformed(evt);
            }
        });

        SemillaL.setText("Semilla:");

        SemillaTF.setFormatterFactory(formSeed);
        SemillaTF.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .add(2, 2, 2)
                .add(ejecutarB)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(ejecutarPrB)
                .add(18, 18, 18)
                .add(SemillaL)
                .add(18, 18, 18)
                .add(SemillaTF, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 89, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(ejecutarPrB)
                    .add(ejecutarB, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 25, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(SemillaL)
                    .add(SemillaTF, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        NiterL.setText("Num It:");

        ParKL.setText("K:");

        LambdaFT.setFormatterFactory(formLambda);
        LambdaFT.setToolTipText("Parametro Lambda");
        LambdaFT.setValue(new Double(0.01));

        LambdaL.setText("Lambda:");

        AnnealingPL.setText("Parametros Annealing");

        KValue.setFormatterFactory(formLambda);
        KValue.setToolTipText("Parametro Lambda");
        KValue.setValue(new Integer(5));

        nIt.setFormatterFactory(formSeed);
        nIt.setToolTipText("Parametro Lambda");
        nIt.setValue(new Integer(1000));

        org.jdesktop.layout.GroupLayout jPanel3Layout = new org.jdesktop.layout.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(AnnealingPL)
                    .add(jPanel3Layout.createSequentialGroup()
                        .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(NiterL)
                            .add(ParKL, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 17, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(LambdaL))
                        .add(36, 36, 36)
                        .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(KValue, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 72, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(LambdaFT, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 72, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(nIt, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 72, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .add(AnnealingPL)
                .add(18, 18, 18)
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(NiterL)
                    .add(nIt, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(ParKL)
                    .add(KValue, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(11, 11, 11)
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(LambdaFT, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(LambdaL))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        annealingTA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                annealingTAMouseClicked(evt);
            }
        });

        jLabel1.setText("Estado Inicial");

        jcbAnimacion.setText("Animaci�n");

        jcbEstadoInicial.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ordenado", "Aleatorio", "Greedy" }));

        jMenu18.setText("Menu");

        Salir17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/door_out.png"))); // NOI18N
        Salir17.setText("Salir");
        Salir17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });
        jMenu18.add(Salir17);

        jMenuBar18.add(jMenu18);

        setJMenuBar(jMenuBar18);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(52, 52, 52)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(67, 67, 67)
                        .add(jLabel1)
                        .add(183, 183, 183)
                        .add(HillClimbingL)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 131, Short.MAX_VALUE)
                        .add(AnnealingL)
                        .add(74, 74, 74))
                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                        .add(layout.createSequentialGroup()
                            .add(22, 22, 22)
                            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                .add(layout.createSequentialGroup()
                                    .add(jcbAnimacion)
                                    .add(105, 105, 105))
                                .add(jcbEstadoInicial, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 190, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                            .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                .add(Inicial, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 234, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(layout.createSequentialGroup()
                                    .add(39, 39, 39)
                                    .add(tfIni, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 153, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                            .add(26, 26, 26)
                            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                .add(tfHC)
                                .add(hillClimbTA, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 234, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                .add(tfSA)
                                .add(annealingTA, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 234, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .add(24, 24, 24)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(jcbEstadoInicial, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jcbAnimacion))
                    .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(HillClimbingL)
                            .add(jLabel1)
                            .add(AnnealingL))
                        .add(14, 14, 14)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(hillClimbTA, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 230, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(Inicial, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 230, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(annealingTA, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 230, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 39, Short.MAX_VALUE)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(tfSA, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(tfHC, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(tfIni, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(18, 18, 18)
                        .add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
// TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_SalirActionPerformed

    private void ejecutarPrBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ejecutarPrBActionPerformed
// TODO add your handling code here:
        try {


            int sm = numForm.parse(SemillaTF.getText()).intValue();
            nc = CiudadesS.getValue();
            ProbTSPBoard TSPB = new ProbTSPBoard(nc, sm, jcbEstadoInicial.getSelectedIndex());
            inicial=TSPB;
            Inicial.setPlano(nc, TSPB.getCityPos(), TSPB.getPath());
            Inicial.repaint();
            tfIni.setText("Coste=" + TSPB.pathCost());
            tfHC.setText(" ");
            tfSA.setText(" ");
            TSPHillClimbingSearch(TSPB, hillClimbTA);
            TSPSimulatedAnnealingSearch(TSPB, annealingTA);
        } catch (ParseException e) {
        }
    }//GEN-LAST:event_ejecutarPrBActionPerformed

    private void ejecutarBMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ejecutarBMousePressed
// TODO add your handling code here:
        nc = CiudadesS.getValue();

        ProbTSPBoard TSPB = new ProbTSPBoard(nc, jcbEstadoInicial.getSelectedIndex());
 inicial=TSPB;
        Inicial.setPlano(nc, TSPB.getCityPos(), TSPB.getPath());
        Inicial.repaint();
        tfIni.setText("Coste=" + TSPB.pathCost());
        tfHC.setText(" ");
        tfSA.setText(" ");
        TSPHillClimbingSearch(TSPB, hillClimbTA);
        TSPSimulatedAnnealingSearch(TSPB, annealingTA);
    }//GEN-LAST:event_ejecutarBMousePressed

    private void hillClimbTAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hillClimbTAMouseClicked
        if ((evt.getClickCount() == 2) && (HC!=null)){
            
           
            List nodes = HC.getPathStates();
            JFrame chart = new TSPChartFrame(computeSeries(nodes),"HC");
            chart.setVisible(true);

        }
    }//GEN-LAST:event_hillClimbTAMouseClicked

    private void annealingTAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_annealingTAMouseClicked
            if ((evt.getClickCount() == 2) && (SA!=null)){
            try {
                int numiters = numForm.parse(nIt.getText()).intValue(); 
                int kvalue = numForm.parse(KValue.getText()).intValue();
                double lambda = numForm.parse(LambdaFT.getText()).doubleValue();
              String param= "It="+numiters+ " k="+ kvalue +" l="+ lambda;
                List nodes = SA.getPathStates();
                JFrame chart = new TSPChartFrame(computeSeries(nodes),"SA/"+param);
                chart.setVisible(true);
            } catch (ParseException ex) {
                Logger.getLogger(ProbTSPJFrame.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }//GEN-LAST:event_annealingTAMouseClicked

    private void TSPHillClimbingSearch(ProbTSPBoard TSPB, TSPDrawPanel a) {
        //System.out.println("\nTSP HillClimbing  -->");
        try {
            Problem problem = new Problem(TSPB, new ProbTSPSuccessorFunction(), new ProbTSPGoalTest(), new ProbTSPHeuristicFunction());
            Search search = new HillClimbingSearch();
            a.setPlano(TSPB.getNCities(), TSPB.getCityPos(), TSPB.getPath());

            Date d1, d2;
            Calendar ti, tf;

            d1 = new Date();
            SearchAgent agent = new SearchAgent(problem, search);
            d2 = new Date();

            ti = Calendar.getInstance();
            tf = Calendar.getInstance();
            ti.setTime(d1);
            tf.setTime(d2);
            long m = tf.getTimeInMillis() - ti.getTimeInMillis();

            //System.out.println();
            if (jcbAnimacion.isSelected()) {
                printActions(agent.getActions(), a);
            }
            HC = search;
            ProbTSPBoard ge = (ProbTSPBoard) search.getGoalState();
            a.setPlano(ge.getNCities(), ge.getCityPos(), ge.getPath());
            tfHC.setText("Pasos= " + agent.getActions().size() + " Coste: " + ge.pathCost() + " Tiempo: " + m + " ms");

            // printInstrumentation(agent.getInstrumentation());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void TSPSimulatedAnnealingSearch(ProbTSPBoard TSPB, TSPDrawPanel a) {
        //System.out.println("\nTSP Simulated Annealing  -->");
        try {
            Problem problem = new Problem(TSPB, new ProbTSPSuccessorFunctionSA(), new ProbTSPGoalTest(), new ProbTSPHeuristicFunction());
            int numiters = numForm.parse(nIt.getText()).intValue();
            numiters -= (numiters % 1000);
            int kvalue = numForm.parse(KValue.getText()).intValue();
            double lambda = numForm.parse(LambdaFT.getText()).doubleValue();
            SimulatedAnnealingSearch search = new SimulatedAnnealingSearch(numiters, 1000, kvalue, lambda);
            //search.traceOn();
            a.setPlano(TSPB.getNCities(), TSPB.getCityPos(), TSPB.getPath());

            Date d1, d2;
            Calendar ti, tf;

            d1 = new Date();
            SearchAgent agent = new SearchAgent(problem, search);
            d2 = new Date();

            ti = Calendar.getInstance();
            tf = Calendar.getInstance();
            ti.setTime(d1);
            tf.setTime(d2);
            long m = tf.getTimeInMillis() - ti.getTimeInMillis();

            if (jcbAnimacion.isSelected()) {
                printActions(agent.getActions(), a);
            }
            
            SA= search;
            ProbTSPBoard ge = (ProbTSPBoard) search.getGoalState();
            a.setPlano(ge.getNCities(), ge.getCityPos(), ge.getPath());
            tfSA.setText("Pasos= " + SA.getPathStates().size() + " Coste: " + ge.pathCost() + " Tiempo: " + m + " ms");


            //printInstrumentation(agent.getInstrumentation());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("empty-statement")
    private void printActions(List actions, TSPDrawPanel a) {
        a.repaint();
        for (int i = 0; i < actions.size(); i++) {

            try {
                String action = (String) actions.get(i);

                int x = DecimalFormat.getInstance().parse(action.substring(0, action.lastIndexOf('|'))).intValue();
                int y = DecimalFormat.getInstance().parse(action.substring(action.lastIndexOf('|') + 1, action.length())).intValue();
                Thread.sleep(200);

                a.changeState(x, y);
                //a.repaint();


            } catch (InterruptedException ex) {
                Logger.getLogger(ProbTSPJFrame.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(ProbTSPJFrame.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    private XYSeries computeSeries(List states) {
        XYSeries series = new XYSeries("");
          series.add(0, inicial.pathCost());
        for (int i = 0; i < states.size(); i++) {
            ProbTSPBoard node = (ProbTSPBoard) states.get(i);
            series.add(i+1, node.pathCost());
        }

        return (series);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new ProbTSPJFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AnnealingL;
    private javax.swing.JLabel AnnealingPL;
    private javax.swing.JSlider CiudadesS;
    private javax.swing.JLabel HillClimbingL;
    private IA.TSP2.TSPDrawPanel Inicial;
    private javax.swing.JFormattedTextField KValue;
    private javax.swing.JFormattedTextField LambdaFT;
    private javax.swing.JLabel LambdaL;
    private javax.swing.JLabel NiterL;
    private javax.swing.JLabel ParKL;
    private javax.swing.JMenuItem Salir17;
    private javax.swing.JLabel SemillaL;
    private javax.swing.JFormattedTextField SemillaTF;
    private IA.TSP2.TSPDrawPanel annealingTA;
    private java.awt.Label ciudadesL;
    private javax.swing.JButton ejecutarB;
    private javax.swing.JButton ejecutarPrB;
    private IA.TSP2.TSPDrawPanel hillClimbTA;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu18;
    private javax.swing.JMenuBar jMenuBar18;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JCheckBox jcbAnimacion;
    private javax.swing.JComboBox jcbEstadoInicial;
    private javax.swing.JFormattedTextField nIt;
    private javax.swing.JTextField tfHC;
    private javax.swing.JTextField tfIni;
    private javax.swing.JTextField tfSA;
    // End of variables declaration//GEN-END:variables
    private NumberFormat numForm;
    private NumberFormatter nfor;
    private DefaultFormatterFactory formSeed;
    private DefaultFormatterFactory formLambda;
}
