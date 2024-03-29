import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Rogue extends JFrame {
    static int rows = 13, columns = 16;
    static String color;
    static Entity[][] G;
    static int percent;
    static Inventory inventory;
    static Player player = new Player();
    static Enemy skele = new Enemy("Skeleton");
    static Empty blank = new Empty();
    static final int UP=1, DOWN=2, LEFT=3, RIGHT=4, MAXROWS=4;
    static String[] logArr = new String[MAXROWS];
    static boolean gameover = false;
    
    public static String updateInventory() {
        StringBuilder str = new StringBuilder("<html><table border=0 style=\"width:122 px\"><tr><th><h2>Inventory</h2></tr>");
        for (int i = 0; i < inventory.size(); i++) {
            str.append("<tr><td border=\"1\">").append(inventory.get(i)).append("</td></tr>");
        }
        str.append("</table>.");
        return str.toString();
    }
    
    public static String html() {
        G[player.getY()][player.getX()] = player;
        G[skele.getY()][skele.getX()] = skele;
        StringBuilder str = new StringBuilder("<html><body><table border=\"0\">");
        
        for (int i = 0; i < rows; i++) { //number of rows
            str.append("<tr>");
            for (int j = 0; j < columns; j++) { //number of columns
                str.append("<td padding=\"0\" border=\"0\" style=\"border-left-style:solid\" width=\"21\" height=\"18\"><img src=\"file:src\\resources\\").append(G[i][j]).append(".png\"></td>");
            }
            str.append("</tr>");
        }
        
        str.append("</table></body></html>");
        return str.toString();
    }

    /**
     * Creates new form NewJFrame.
     */
    public Rogue() {
        G = new Entity[rows][columns];
        inventory = new Inventory();
        
        //Populate grid
        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < columns; x++) {
                G[y][x] = blank; //Fills grid with empty images
            }
        }
        for (int i = 0; i < 4; i++) { //Randomly generate (max) 4 food
            G[(int) (Math.random() * rows)][(int) (Math.random() * columns)] = new Item();
        }
        G[player.getY()][player.getX()] = player;
        G[skele.getY()][skele.getX()] = skele;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        window = new JLabel(html());
        stats = new javax.swing.JLabel();
        log = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        inventoryTable = new javax.swing.JLabel();
        use = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        upButton = new javax.swing.JButton();
        leftButton = new javax.swing.JButton();
        downButton = new javax.swing.JButton();
        rightButton = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        exit = new javax.swing.JMenuItem();
        readme = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Rogue");
        setResizable(false);

        jPanel1.setPreferredSize(new java.awt.Dimension(470, 480));

        window.setBackground(new java.awt.Color(255, 255, 255));
        window.setFont(new java.awt.Font("Monospaced", 0, 11)); // NOI18N
        window.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        window.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(109, 109, 109)));
        window.setOpaque(true);

        stats.setBackground(new java.awt.Color(255, 255, 255));
        stats.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        stats.setText("<html><br>HP: <font color='green'>" + player.getHP() + "/" + player.getMaxHP() + "</font><br>EXP: " + player.getEXP() + "/" + player.getMaxEXP() + "<br>Level: " + player.getLevel());
        stats.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        stats.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(109, 109, 109)));
        stats.setOpaque(true);

        log.setFont(new Font("Monospaced", Font.PLAIN, 13));
        log.setBackground(new java.awt.Color(255, 255, 255));
        log.setText("<html>");
        log.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        log.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(109, 109, 109)));
        log.setOpaque(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(window, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(log, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(stats, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(window, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(log, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stats, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );

        inventoryTable.setBackground(new java.awt.Color(255, 255, 255));
        inventoryTable.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        inventoryTable.setText(updateInventory());
        inventoryTable.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        inventoryTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(109, 109, 109)));
        inventoryTable.setOpaque(true);

        use.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                useActionPerformed(evt);
            }
        });

        jLabel3.setText("Use:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(inventoryTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(use, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(inventoryTable, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(use, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        upButton.setText("Up");
        upButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upButtonActionPerformed(evt);
            }
        });

        leftButton.setText("Left");
        leftButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leftButtonActionPerformed(evt);
            }
        });

        downButton.setText("Down");
        downButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                downButtonActionPerformed(evt);
            }
        });

        rightButton.setText("Right");
        rightButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rightButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(downButton)
                    .addComponent(upButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(leftButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rightButton)
                .addContainerGap())
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {downButton, leftButton, rightButton, upButton});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(upButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(leftButton)
                    .addComponent(rightButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(downButton)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jMenu1.setText("File");

        exit.setText("Exit");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        jMenu1.add(exit);

        jMenuBar1.add(jMenu1);

        readme.setText("README");

        jMenuItem2.setText("ReadMe.txt");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        readme.add(jMenuItem2);

        jMenuBar1.add(readme);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void collision(int direction, Enemy ent) {
        Entity test = new Empty();
        switch (direction) {
            case 1: test = G[ent.getY() - 1][ent.getX()]; break;
            case 2: test = G[ent.getY() + 1][ent.getX()]; break;
            case 3: test = G[ent.getY()][ent.getX() - 1]; break;
            case 4: test = G[ent.getY()][ent.getX() + 1]; break;
        }
        if (test.equals(blank)) { //If no obstacle
            //Move one space
            G[ent.getY()][ent.getX()] = blank;
            switch (direction) {
                case 1: ent.setY(-1); break;
                case 2: ent.setY(1); break;
                case 3: ent.setX(-1); break;
                case 4: ent.setX(1); break;
                default: break;
            }
            G[ent.getY()][ent.getX()] = ent;
            window.setText(html());
        } else { //If obstacle present
            if (test.toString().equals("Skeleton")) { //If obstacle is skeleton enemy
                //Begin battle
                int damage1 = -(int) (Math.random() * (player.getLevel() + 3) + 2);
                skele.addHP(damage1);
                addToLog("<font color='green'>" + damage1 + " HP</font> to skeleton.(" + skele.getHP() + "/" + skele.getMaxHP() + ")");
                
                
                if (skele.getHP() <= 0) { //If skeleton dies
                    addToLog("<font color='green'>Skeleton defeated! </font><font color='blue'>EXP + 7</font>");
                    G[skele.getY()][skele.getX()] = blank;
                    skele.setXabs((int) (Math.random() * columns));
                    skele.setYabs((int) (Math.random() * rows));
                    player.addEXP(7);
                    if (player.check()) {
                        addToLog("<font color='blue'>LEVEL UP! Stats increased.</font>");
                    }
                    skele.death();
                    //5% chance of spawning rare watermelon
                    int ran;
                    if ((ran = (int) (Math.random() * 20) + 1) == 1) {
                        G[(int) (Math.random() * rows)][(int) (Math.random() * columns)] = new Item("Watermelon");
                        addToLog("<font color='purple'>Look! A shiny watermelon appeared!</font>");
                    } else if (ran > 1 && ran < 5) { //15% chance of spawning regular fruit
                        G[(int) (Math.random() * rows)][(int) (Math.random() * columns)] = new Item();
                        addToLog("<font color='purple'>A fruit appeared!</font>");
                    }
                } else { //Otherwise attack Player
                    //If damage greater than 0, hit. Otherwise display "missed" message.
                    int damage2 = -(int) (Math.random() * (4 + skele.deaths));
                    player.addHP(damage2);
                    addToLog(damage2 < 0 ? ("<font color='red'>" + damage2 + " HP</font> to Player.") : ("<font color='green'>Skeleton missed!</font>"));
                    if (player.getHP() <= 0) {
                        player.setHP(0);
                        gameover = true;
                        disableGame();
                    }
                }
                percent = (int) ((double) player.getHP() / (double) player.getMaxHP() * 100);
                if (percent < 50) {
                    if (percent < 25) {
                        color = "red";
                    } else {
                        color = "orange";
                    }
                } else {
                    color = "green";
                }
                window.setText(gameover ? "Game Over! Try again." : html());
                stats.setText("<html><br>HP: <font color='" + color + "'>" + player.getHP() + "/" + player.getMaxHP() + "</font><br>EXP: " + player.getEXP() + "/" + player.getMaxEXP() + "<br>Level: " + player.getLevel());
            } else { //If obstacle is item
                //Store item in inventory
                G[ent.getY()][ent.getX()] = blank;
                switch (direction) {
                    case 1: ent.setY(-1); break;
                    case 2: ent.setY(1); break;
                    case 3: ent.setX(-1); break;
                    case 4: ent.setX(1); break;
                }
                if (ent.equals(player)) {
                    inventory.add(new Item(G[ent.getY()][ent.getX()].toString()));  //Add item to inventory
                }
                addToLog(G[ent.getY()][ent.getX()].toString() + " picked up."); //Add action to log
                inventoryTable.setText(updateInventory());                      //Update inventory interface
                G[ent.getY()][ent.getX()] = ent;
                window.setText(html());                                        //Update main interface
            }
        }
    }
    
    private void disableGame() {
        use.setEnabled(false);
        upButton.setEnabled(false);
        downButton.setEnabled(false);
        leftButton.setEnabled(false);
        rightButton.setEnabled(false);
    }
    
    /**
     * Appends text to log from the top.
     */
    private void addToLog(String action) {
        System.arraycopy(logArr, 0, logArr, 1, logArr.length - 1); //Offset log array
        logArr[0] = action;
        final StringBuilder str = new StringBuilder("<html>");
        for (int i = 0; i < MAXROWS; i++) {
            str.append(logArr[i] == null ? "" : (logArr[i] + "<br>"));
        }
        log.setText(str.toString());
    }
    
    private void upButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upButtonActionPerformed
        player.setDirection("1");
        moveUp(player);
    }//GEN-LAST:event_upButtonActionPerformed

    public void moveUp(Enemy ent) {
        if (ent.getY() > 0) {
            collision(UP, ent);
        }
    }
    
    private void downButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_downButtonActionPerformed
        player.setDirection("2");
        moveDown(player);
    }//GEN-LAST:event_downButtonActionPerformed

    public void moveDown(Enemy ent) {
        if (ent.getY() < G.length - 1) {
            collision(DOWN, ent);
        }
    }
    
    private void leftButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leftButtonActionPerformed
        player.setDirection("3");
        moveLeft(player);
    }//GEN-LAST:event_leftButtonActionPerformed

    public void moveLeft(Enemy ent) {
        if (ent.getX() > 0) {
            collision(LEFT, ent);
        }
    }
    
    private void rightButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rightButtonActionPerformed
        player.setDirection("4");
        moveRight(player);
    }//GEN-LAST:event_rightButtonActionPerformed

    public void moveRight(Enemy ent) {
        if (ent.getX() < G[0].length - 1) {
            collision(RIGHT, ent);
        }
    }
    
    private void useActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_useActionPerformed
        String input = use.getText();
        if (!input.isEmpty()) {
            final int index = inventory.search(input);
            if (index != -1) {
                player.consume(inventory.get(index));
                addToLog("<font color='blue'>Player consumed " + inventory.get(index) + "!</font><font color='green'> HP+" + inventory.get(index).restore() + "</font>");
                inventory.kill(index);
                inventoryTable.setText(updateInventory());
                percent = (int) ((double) player.getHP() / (double) player.getMaxHP() * 100);
                if (percent < 50) {
                    if (percent < 25) {
                        color = "red";
                    } else {
                        color = "orange";
                    }
                } else {
                    color = "green";
                }
                stats.setText("<html><br>HP: <font color='" + color + "'>" + player.getHP() + "/" + player.getMaxHP() + "</font><br>EXP: " + player.getEXP() + "/" + player.getMaxEXP() + "<br>Level: " + player.getLevel());
            }
            use.setText("");
        }
    }//GEN-LAST:event_useActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        try {
           Desktop.getDesktop().open(new File("readme.txt"));
        } catch (IOException e) {
            System.err.println("IOException: " + e.getMessage());
        }   
        
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }//GEN-LAST:event_exitActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Rogue().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton downButton;
    private javax.swing.JMenuItem exit;
    private javax.swing.JLabel inventoryTable;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton leftButton;
    private javax.swing.JLabel log;
    private javax.swing.JMenu readme;
    private javax.swing.JButton rightButton;
    private javax.swing.JLabel stats;
    private javax.swing.JButton upButton;
    private javax.swing.JTextField use;
    private javax.swing.JLabel window;
    // End of variables declaration//GEN-END:variables
}
