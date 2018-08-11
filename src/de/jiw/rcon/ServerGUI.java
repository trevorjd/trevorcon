/*
 * Decompiled with CFR 0_132.
 * 
 * Could not load the following classes:
 *  de.jiw.network.core.codec.Message
 *  org.netbeans.lib.awtextra.AbsoluteConstraints
 *  org.netbeans.lib.awtextra.AbsoluteLayout
 */
package de.jiw.rcon;

import de.jiw.rcon.packets.*;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

public class ServerGUI
extends JFrame {
    private Rcon main;
    private List<String> admins = null;
    private List<String[]> bans = null;
    private List<Integer> images = null;
    private String currentPlayername = null;
    private short currentPlayerhealth = 0;
    private byte currentPlayerhunger = 0;
    private byte currentPlayerthirst = 0;
    private boolean currentPlayerbrokenbones = false;
    private DefaultListModel<String> playerListModel = new DefaultListModel();
    private DefaultListModel<String> adminListModel = new DefaultListModel();
    private DefaultListModel<String> banListModel = new DefaultListModel();
    private DefaultListModel<String> customImageListModel = new DefaultListModel();
    private HashMap<Integer, byte[]> pendingImages = new HashMap();
    private HashMap<Integer, ImageIcon> customImages = new HashMap();
    private HashMap<Integer, BufferedImage> customImagesBuff = new HashMap();
    public static final String NUMERIC_PATTERN = "[-]?[\\d]+[.]?[\\d]*";
    public static final String COLOR_PATTERN = "\\[#([0-9A-Fa-f]{2}){3}\\]";
    public static final int COLOR_PATTERN_LEN = 9;
    public static final int[] DAYS_PER_MONTH = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public static final String CUSTOMIMGAGE_NAMEPREFIX = "Image ID ";
    boolean pressed = false;
    public JList adminlist;
    private JScrollPane adminlist_scrollpane;
    private JButton bAddAdmin;
    private JButton bBan;
    private JButton bBanPlayer;
    private JButton bChatSend;
    private JButton bCleanupCorpses;
    private JButton bCleanupItems;
    private JButton bCleanupTrees;
    private JButton bDeleteImage;
    private JButton bEditServerDate;
    private JButton bEditServerTime;
    private JButton bHeal;
    private JButton bImgBanPlayer;
    private JButton bKick;
    private JButton bRemoveAdmin;
    private JButton bSaveall;
    private JButton bSendText;
    private JButton bSendText1;
    private JButton bSendYell;
    private JButton bSetHealth;
    private JButton bSetHunger;
    private JButton bSetThirst;
    private JButton bShutdown;
    private JButton bSlap;
    private JButton bTeleport;
    private JButton bUnbanPlayer;
    private JList banlist;
    private JScrollPane banlist_scrollpane;
    public JTextArea chat;
    private JTextField chat_input;
    private JScrollPane chat_scrollpane;
    private JLabel customimage_preview;
    private JPanel customimage_preview_bck;
    private JList customimages;
    private JScrollPane customimages_scrollpane;
    private JLabel lBanPlayerDuration;
    private JLabel lBanPlayerDurationHint;
    private JLabel lBanPlayerName;
    private JLabel lBanPlayerReason;
    private JLabel lBandate;
    private JLabel lBandateValue;
    private JLabel lBannedby;
    private JLabel lBannedbyValue;
    private JLabel lBanneduntil;
    private JLabel lBanneduntilValue;
    private JLabel lBanreason;
    private JLabel lBanreasonValue;
    private JLabel lChunkpos;
    private JLabel lChunkposValue;
    private JLabel lDate;
    private JLabel lHealth;
    private JLabel lHealthValue;
    private JLabel lHunger;
    private JLabel lHungerValue;
    private JLabel lImgDate;
    private JLabel lImgDateValue;
    private JLabel lImgName;
    private JLabel lImgNameValue;
    private JLabel lImgPlayer;
    private JLabel lImgPlayerValue;
    private JLabel lImgSize;
    private JLabel lImgSizeValue;
    private JLabel lIsAdmin;
    private JLabel lMaxPlayers;
    private JLabel lPlayerlistTitle;
    private JLabel lPlayername;
    private JLabel lPlayernameValue;
    private JLabel lPosition;
    private JLabel lPositionValue;
    private JLabel lServerPassword;
    private JLabel lThirst;
    private JLabel lThirstValue;
    private JLabel lTime;
    public JTextArea output;
    private JScrollPane output_scrollpane;
    private JPanel pAdmins;
    private JPanel pBanInfos;
    private JPanel pBanPlayer;
    private JPanel pBannedPlayers;
    private JPanel pCleanup;
    private JPanel pDate;
    private JPanel pGeneral;
    private JPanel pPlayerInfos;
    private JPanel pPlayerMessage;
    private JPanel pPlayerMessage1;
    private JPanel pPlayerPosition;
    private JPanel pPlayerPunishment;
    private JPanel pPlayerStatus;
    private JPanel pPlayerlist;
    private JPanel pServer;
    private JPanel pTab1;
    private JPanel pTab2;
    private JPanel pTab3;
    private JPanel pTab4;
    private JPanel pTab5;
    private JPanel pTab6;
    private JList playerlist;
    private JScrollPane playerlist_scrollpane;
    private JSpinner sBanPlayerDuration;
    private JSpinner sMaxPlayers;
    private JTextField tBanPlayerName;
    private JTextField tBanPlayerReason;
    private JTextField tServerDate;
    private JTextField tServerPassword;
    private JTextField tServerTime;
    private JTabbedPane tpMain;

    // Trevors additions
    private Properties trevProp;
    private JPanel pTab7;
    private JLabel lTrevTabTitle;
    private boolean wordwrap;
    private String adminName;
    private String adminChatColor;
    private JLabel lAdminName;
    private JTextField tAdminName;
    private JLabel lAdminChatColor;
    private JTextField tAdminChatColor;
    private JLabel lWordWrap;
    private JCheckBox cWordWrap;
    private int windowWidth;
    private int windowHeight;
    private int chatWindowWidth;
    private int chatWindowHeight;
    private int chatInputWidth;
    private int chatInputY;
    private int chatSendX;
    private int chatSendY;
    private int chatSendWidth;
    private int chatSendHeight;
    private JLabel lGUIWidth;
    private JLabel lGUIHeight;
    private JLabel lGUIWidthTail;
    private JLabel lGUIHeightTail;
    private JTextField tGUIWidth;
    private JTextField tGUIHeight;
    private JButton bSaveSettings;
    private String verNum;
    private String chatBuffer;
    private boolean chatPaused;
    private JCheckBox cPauseChat;
    private Timer chatPausedTimer;
    private JLabel lChatPaused;
    private String trevrconFeatures;

    public ServerGUI(Rcon main, boolean integrated) {
        this.main = main;
        this.initComponents();
        if (!integrated) {
            this.tpMain.remove(this.pTab1);
        }
    }

    public synchronized void createPendingImageData(int id, byte[] bytes) {
        this.pendingImages.put(id, bytes);
    }

    public synchronized byte[] getPendingImageData(int id) {
        return this.pendingImages.get(id);
    }

    public void createFinalImage(int id, byte[] bytes) {
        BufferedImage buff = this.byteArrayToBufferedImage(bytes);
        if (buff != null) {
            ImageIcon img = new ImageIcon(buff.getScaledInstance(this.customimage_preview.getWidth(), this.customimage_preview.getHeight(), 4));
            this.customimage_preview.setIcon(img);
            this.customimage_preview.repaint();
            this.customImages.put(id, img);
            this.customImagesBuff.put(id, buff);
        }
    }

    protected BufferedImage byteArrayToBufferedImage(byte[] bytes) {
        BufferedImage bufferedImage;
        bufferedImage = null;
        try {
            try (ByteArrayInputStream in = new ByteArrayInputStream(bytes);){
                bufferedImage = ImageIO.read(in);
            }
        }
        catch (Exception e) {
            System.out.println("Unable to convert ByteArray to BufferedImage");
            e.printStackTrace();
        }
        return bufferedImage;
    }

    public void guiAddOutput(String output) {
        this.output.setText(this.output.getText() + "<br>" + output);
    }

    // trevorised
    public void guiAddChatMessage(String message) {
        if(chatPaused)
        {
            message = message.replaceAll(COLOR_PATTERN, "");
            this.chatBuffer = this.chatBuffer + "\n" + message;
        } else
        {
            message = message.replaceAll(COLOR_PATTERN, "");
            String t = this.chat.getText();
            if (t.isEmpty()) {
                this.chat.setText(message);
            } else {
                this.chat.setText(this.chat.getText() + "\n" + message);
            }
        }
    }

    // trevorism
    private void unpauseChat()
    {
        String t = this.chat.getText();
        if (t.isEmpty()) {
            this.chat.setText(this.chatBuffer);
        } else {
            this.chat.setText(t + this.chatBuffer);
        }
        this.chatBuffer = "";
        this.chatPausedTimer.stop();
        lChatPaused.setText("");
        chatPaused = false;
    }

    public void guiUpdatePlayerList() {
        this.updatePlayerList();
    }

    public void guiUpdateBanList(List<String[]> bans) {
        this.bans = bans;
        this.updateBanList();
    }

    public void guiUpdateAdminList(ArrayList<String> admins) {
        this.admins = admins;
        this.updateAdminList();
    }

    public void guiUpdateImageList(ArrayList<Integer> images) {
        this.images = images;
        Collections.sort(images);
        this.customimage_preview.setIcon(null);
        this.lImgPlayerValue.setText("N/A");
        this.lImgNameValue.setText("N/A");
        this.lImgDateValue.setText("N/A");
        this.lImgSizeValue.setText("N/A");
        this.updateImageList();
    }

    public void guiUpdateServerInfo(int maxPlayers, String password) {
        this.sMaxPlayers.setValue(maxPlayers);
        this.tServerPassword.setText(password);
    }

    public void guiUpdateServerTime(int hour, int minute, int day, int month, int year) {
        if (hour >= 12) {
            this.tServerTime.setText(String.format("%02d:%02d pm", hour - 12, minute));
        } else {
            this.tServerTime.setText(String.format("%02d:%02d am", hour, minute));
        }
        this.tServerDate.setText(String.format("%02d/%02d/%04d", month, day, year));
    }

    public void guiAddAdmin(String name) {
        if (name != null && !this.admins.contains(name)) {
            this.admins.add(name);
        }
        this.updateAdminList();
    }

    public void guiRemoveAdmin(String name) {
        if (name != null) {
            this.admins.remove(name);
        }
        this.updateAdminList();
    }

    public void guiRequestBanList() {
        RequestBanlistPacket request = new RequestBanlistPacket();
        this.main.sendMessage(request);
    }

    public void guiUnbanPlayer(String name) {
        if (name != null) {
            this.admins.remove(name);
        }
        this.updateAdminList();
    }

    public void guiUpdatePlayerInfo(String playername, boolean isAdmin, String pos, String chunkpos, short health, short armor, byte hunger, byte thirst, boolean brokenbones, boolean dead) {
        this.currentPlayername = playername;
        this.currentPlayerhealth = health;
        this.currentPlayerhunger = hunger;
        this.currentPlayerthirst = thirst;
        this.currentPlayerbrokenbones = brokenbones;
        this.lPlayernameValue.setText(playername);
        this.lIsAdmin.setText(isAdmin ? "(ADMIN)" : "");
        this.lPositionValue.setText(pos);
        this.lChunkposValue.setText(chunkpos);
        this.lHealthValue.setText(String.valueOf(health));
        this.lHungerValue.setText(String.valueOf(hunger));
        this.lThirstValue.setText(String.valueOf(thirst));
    }

    public void guiUpdateImageInfo(int imageID, String imagename, int size, String playername) {
        this.lImgNameValue.setText(imagename);
        this.lImgSizeValue.setText("" + size / 1000 + " KB");
        this.lImgPlayerValue.setText(playername);
    }

    public void guiUpdate() {
        if (this.tpMain.getSelectedComponent() == this.pTab4 && this.playerlist.getSelectedValue() != null) {
            String playername = (String)this.playerlist.getSelectedValue();
            RequestPlayerInfoPacket request = new RequestPlayerInfoPacket(playername);
            this.main.sendMessage(request);
        }
    }

    private void updatePlayerList() {
        this.playerListModel.clear();
        int i = 0;
        int j = 0;
        while (j < this.main.playerList.size()) {
            String p = this.main.playerList.get(i);
            if (p != null) {
                this.playerListModel.addElement(p);
                ++j;
            }
            ++i;
        }
    }

    private void updateAdminList() {
        this.adminListModel.clear();
        if (this.admins != null && !this.admins.isEmpty()) {
            for (String s : this.admins) {
                this.adminListModel.addElement(s);
            }
        }
    }

    private void updateBanList() {
        this.banListModel.clear();
        if (this.bans != null && !this.bans.isEmpty()) {
            for (String[] s : this.bans) {
                if (s == null || s.length <= 0) continue;
                this.banListModel.addElement(s[0]);
            }
        }
    }

    private void updateImageList() {
        this.customImageListModel.clear();
        if (this.images != null && !this.images.isEmpty()) {
            for (Integer i : this.images) {
                this.customImageListModel.addElement(CUSTOMIMGAGE_NAMEPREFIX + i);
            }
        }
    }

    private void initComponents() {
        this.pPlayerlist = new JPanel();
        this.lPlayerlistTitle = new JLabel();
        this.playerlist_scrollpane = new JScrollPane();
        this.playerlist = new JList();
        this.tpMain = new JTabbedPane();
        this.pTab1 = new JPanel();
        this.output_scrollpane = new JScrollPane();
        this.output = new JTextArea();
        this.pTab2 = new JPanel();
        this.chat_scrollpane = new JScrollPane();
        this.chat = new JTextArea();
        this.chat_input = new JTextField();
        this.bChatSend = new JButton();
        this.pTab3 = new JPanel();
        this.pCleanup = new JPanel();
        this.bCleanupItems = new JButton();
        this.bCleanupCorpses = new JButton();
        this.bCleanupTrees = new JButton();
        this.pDate = new JPanel();
        this.lTime = new JLabel();
        this.tServerTime = new JTextField();
        this.tServerDate = new JTextField();
        this.lDate = new JLabel();
        this.bEditServerTime = new JButton();
        this.bEditServerDate = new JButton();
        this.pServer = new JPanel();
        this.bSaveall = new JButton();
        this.bShutdown = new JButton();
        this.pGeneral = new JPanel();
        this.lMaxPlayers = new JLabel();
        this.lServerPassword = new JLabel();
        this.tServerPassword = new JTextField();
        this.sMaxPlayers = new JSpinner();
        this.pAdmins = new JPanel();
        this.adminlist_scrollpane = new JScrollPane();
        this.adminlist = new JList();
        this.bAddAdmin = new JButton();
        this.bRemoveAdmin = new JButton();
        this.pPlayerMessage1 = new JPanel();
        this.bSendText1 = new JButton();
        this.pTab4 = new JPanel();
        this.pPlayerInfos = new JPanel();
        this.lPlayername = new JLabel();
        this.lPlayernameValue = new JLabel();
        this.lPosition = new JLabel();
        this.lHealth = new JLabel();
        this.lHunger = new JLabel();
        this.lPositionValue = new JLabel();
        this.lHealthValue = new JLabel();
        this.lHungerValue = new JLabel();
        this.lIsAdmin = new JLabel();
        this.lChunkpos = new JLabel();
        this.lThirst = new JLabel();
        this.lThirstValue = new JLabel();
        this.lChunkposValue = new JLabel();
        this.pPlayerPosition = new JPanel();
        this.bTeleport = new JButton();
        this.pPlayerStatus = new JPanel();
        this.bSetHealth = new JButton();
        this.bSetHunger = new JButton();
        this.bSetThirst = new JButton();
        this.bHeal = new JButton();
        this.pPlayerMessage = new JPanel();
        this.bSendText = new JButton();
        this.bSendYell = new JButton();
        this.pPlayerPunishment = new JPanel();
        this.bKick = new JButton();
        this.bBan = new JButton();
        this.bSlap = new JButton();
        this.pTab5 = new JPanel();
        this.pBannedPlayers = new JPanel();
        this.banlist_scrollpane = new JScrollPane();
        this.banlist = new JList();
        this.bUnbanPlayer = new JButton();
        this.pBanInfos = new JPanel();
        this.lBannedby = new JLabel();
        this.lBannedbyValue = new JLabel();
        this.lBandate = new JLabel();
        this.lBandateValue = new JLabel();
        this.lBanneduntil = new JLabel();
        this.lBanneduntilValue = new JLabel();
        this.lBanreason = new JLabel();
        this.lBanreasonValue = new JLabel();
        this.pBanPlayer = new JPanel();
        this.lBanPlayerName = new JLabel();
        this.lBanPlayerDuration = new JLabel();
        this.lBanPlayerReason = new JLabel();
        this.tBanPlayerName = new JTextField();
        this.tBanPlayerReason = new JTextField();
        this.sBanPlayerDuration = new JSpinner();
        this.lBanPlayerDurationHint = new JLabel();
        this.bBanPlayer = new JButton();
        this.pTab6 = new JPanel();
        this.pTab7 = new JPanel();
        this.customimages_scrollpane = new JScrollPane();
        this.customimages = new JList();
        this.customimage_preview_bck = new JPanel();
        this.customimage_preview = new JLabel();
        this.lImgName = new JLabel();
        this.lImgDate = new JLabel();
        this.lImgPlayer = new JLabel();
        this.bImgBanPlayer = new JButton();
        this.lImgNameValue = new JLabel();
        this.lImgDateValue = new JLabel();
        this.lImgPlayerValue = new JLabel();
        this.lImgSize = new JLabel();
        this.lImgSizeValue = new JLabel();
        this.bDeleteImage = new JButton();
        this.setDefaultCloseOperation(3);
        loadTrevorsProperties(); // trevor
        this.setTitle("TrevoRCON - Rising World RCON Tool " + verNum); // trevor
        this.getContentPane().setLayout((LayoutManager)new AbsoluteLayout());
        this.chatBuffer = "";
        this.pPlayerlist.setLayout((LayoutManager)new AbsoluteLayout());
        this.lPlayerlistTitle.setFont(new Font("Tahoma", 1, 12));
        this.lPlayerlistTitle.setHorizontalAlignment(0);
        this.lPlayerlistTitle.setText("- Playerlist -");
        this.pPlayerlist.add((Component)this.lPlayerlistTitle, (Object)new AbsoluteConstraints(20, 0, 170, -1));
        this.playerlist_scrollpane.setVerticalScrollBarPolicy(22);
        this.playerlist_scrollpane.setMaximumSize(new Dimension(72, 130));
        this.playerlist.setModel(this.playerListModel);
        this.playerlist.setSelectionMode(0);
        this.playerlist.addMouseListener(new MouseAdapter(){

            @Override
            public void mousePressed(MouseEvent evt) {
                ServerGUI.this.playerlistMousePressed(evt);
            }
        });
        this.playerlist.addListSelectionListener(new ListSelectionListener(){

            @Override
            public void valueChanged(ListSelectionEvent evt) {
                ServerGUI.this.playerlistValueChanged(evt);
            }
        });
        this.playerlist_scrollpane.setViewportView(this.playerlist);
        this.pPlayerlist.add((Component)this.playerlist_scrollpane, (Object)new AbsoluteConstraints(0, 20, 210, windowHeight -20));
        this.getContentPane().add((Component)this.pPlayerlist, (Object)new AbsoluteConstraints(0, 10, -1, windowHeight));
        this.tpMain.addChangeListener(new ChangeListener(){

            @Override
            public void stateChanged(ChangeEvent evt) {
                ServerGUI.this.tpMainStateChanged(evt);
            }
        });
        this.lChatPaused = new JLabel();
        this.getContentPane().add((Component)this.lChatPaused, (Object)new AbsoluteConstraints(windowWidth, 12, -1, -1));
        this.chatPausedTimer = new Timer(500, new ActionListener() {
            private int count = 0;
            public void actionPerformed(ActionEvent e) {
                if (count % 2 == 0) {
                    lChatPaused.setVisible(true);
                } else {
                    lChatPaused.setVisible(false);
                }
                count++;
            }
        });
        // a little bit of trevor
        this.cPauseChat = new JCheckBox("Pause");
        cPauseChat.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                JCheckBox cb = (JCheckBox) e.getSource();
                if (cb.isSelected())
                {
                    chatPaused = true;
                    lChatPaused.setText("***Chat Paused***");
                    chatPausedTimer.start();
                } else unpauseChat();
            }
        });
        this.getContentPane().add((Component)this.cPauseChat, (Object)new AbsoluteConstraints(windowWidth + 150, 12, -1, -1));
        //

        this.pTab1.setLayout((LayoutManager)new AbsoluteLayout());
        this.output.setColumns(20);
        this.output.setRows(5);
        this.output_scrollpane.setViewportView(this.output);
        this.pTab1.add((Component)this.output_scrollpane, (Object)new AbsoluteConstraints(0, 0, windowWidth, windowHeight));
        this.tpMain.addTab("Log", this.pTab1);


        this.pTab2.setLayout((LayoutManager)new AbsoluteLayout());
        this.chat.setEditable(false);
        if(wordwrap)
        {
            chat.setWrapStyleWord(true); // trevor
            chat.setLineWrap(true); // trevor
        }
        this.chat.setColumns(20);
        this.chat.setFont(new Font("Tahoma", 1, 12));
        this.chat.setRows(1);
        this.chat_scrollpane.setViewportView(this.chat);
        this.pTab2.add((Component)this.chat_scrollpane, (Object)new AbsoluteConstraints(0, 0, chatWindowWidth, chatWindowHeight));


        this.chat_input.setFont(new Font("Tahoma", 1, 12));
        this.chat_input.addKeyListener(new KeyAdapter(){

            @Override
            public void keyPressed(KeyEvent evt) {
                ServerGUI.this.chat_inputKeyPressed(evt);
            }
        });
        this.pTab2.add((Component)this.chat_input, (Object)new AbsoluteConstraints(0, chatInputY, chatInputWidth, chatSendHeight));
        this.bChatSend.setText("SEND");
        this.bChatSend.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ServerGUI.this.bChatSendActionPerformed(evt);
            }
        });
        this.pTab2.add((Component)this.bChatSend, (Object)new AbsoluteConstraints(chatSendX, chatSendY, chatSendWidth, chatSendHeight));
        this.tpMain.addTab("Chat", this.pTab2);
        this.pTab3.setLayout((LayoutManager)new AbsoluteLayout());
        this.pCleanup.setBorder(BorderFactory.createTitledBorder(null, "Clean up", 0, 0, new Font("Tahoma", 1, 12)));
        this.pCleanup.setLayout((LayoutManager)new AbsoluteLayout());
        this.bCleanupItems.setText("Items");
        this.bCleanupItems.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ServerGUI.this.bCleanupItemsActionPerformed(evt);
            }
        });
        this.pCleanup.add((Component)this.bCleanupItems, (Object)new AbsoluteConstraints(10, 20, 130, -1));
        this.bCleanupCorpses.setText("Corpses");
        this.bCleanupCorpses.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ServerGUI.this.bCleanupCorpsesActionPerformed(evt);
            }
        });
        this.pCleanup.add((Component)this.bCleanupCorpses, (Object)new AbsoluteConstraints(10, 50, 130, -1));
        this.bCleanupTrees.setText("Trees");
        this.bCleanupTrees.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ServerGUI.this.bCleanupTreesActionPerformed(evt);
            }
        });
        this.pCleanup.add((Component)this.bCleanupTrees, (Object)new AbsoluteConstraints(10, 80, 130, -1));
        this.pTab3.add((Component)this.pCleanup, (Object)new AbsoluteConstraints(410, 10, 150, 120));
        this.pDate.setBorder(BorderFactory.createTitledBorder(null, "Time and Date", 0, 0, new Font("Tahoma", 1, 12)));
        this.pDate.setLayout((LayoutManager)new AbsoluteLayout());
        this.lTime.setFont(new Font("Tahoma", 1, 12));
        this.lTime.setText("Ingame time:");
        this.pDate.add((Component)this.lTime, (Object)new AbsoluteConstraints(20, 30, 143, -1));
        this.tServerTime.setHorizontalAlignment(0);
        this.tServerTime.setToolTipText("hh:mm");
        this.pDate.add((Component)this.tServerTime, (Object)new AbsoluteConstraints(160, 25, 107, -1));
        this.tServerDate.setHorizontalAlignment(0);
        this.tServerDate.setToolTipText("yyyy/mm/dd");
        this.pDate.add((Component)this.tServerDate, (Object)new AbsoluteConstraints(160, 55, 107, -1));
        this.lDate.setFont(new Font("Tahoma", 1, 12));
        this.lDate.setText("Ingame date:");
        this.pDate.add((Component)this.lDate, (Object)new AbsoluteConstraints(20, 60, 143, -1));
        this.bEditServerTime.setText("Change");
        this.bEditServerTime.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ServerGUI.this.bEditServerTimeActionPerformed(evt);
            }
        });
        this.pDate.add((Component)this.bEditServerTime, (Object)new AbsoluteConstraints(280, 24, 103, -1));
        this.bEditServerDate.setText("Change");
        this.bEditServerDate.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ServerGUI.this.bEditServerDateActionPerformed(evt);
            }
        });
        this.pDate.add((Component)this.bEditServerDate, (Object)new AbsoluteConstraints(280, 54, 103, -1));
        this.pTab3.add((Component)this.pDate, (Object)new AbsoluteConstraints(10, 130, 400, 100));
        this.pServer.setBorder(BorderFactory.createTitledBorder(null, "Server", 0, 0, new Font("Tahoma", 1, 12)));
        this.pServer.setLayout((LayoutManager)new AbsoluteLayout());
        this.bSaveall.setText("Save all");
        this.bSaveall.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ServerGUI.this.bSaveallActionPerformed(evt);
            }
        });
        this.pServer.add((Component)this.bSaveall, (Object)new AbsoluteConstraints(10, 30, 130, -1));
        this.bShutdown.setText("Shutdown");
        this.bShutdown.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ServerGUI.this.bShutdownActionPerformed(evt);
            }
        });
        this.pServer.add((Component)this.bShutdown, (Object)new AbsoluteConstraints(10, 60, 130, -1));
        this.pTab3.add((Component)this.pServer, (Object)new AbsoluteConstraints(410, 130, 150, 100));
        this.pGeneral.setBorder(BorderFactory.createTitledBorder(null, "General", 0, 0, new Font("Tahoma", 1, 12)));
        this.pGeneral.setLayout((LayoutManager)new AbsoluteLayout());
        this.lMaxPlayers.setFont(new Font("Tahoma", 1, 12));
        this.lMaxPlayers.setText("Max player count:");
        this.pGeneral.add((Component)this.lMaxPlayers, (Object)new AbsoluteConstraints(20, 30, 143, -1));
        this.lServerPassword.setFont(new Font("Tahoma", 1, 12));
        this.lServerPassword.setText("Server password:");
        this.pGeneral.add((Component)this.lServerPassword, (Object)new AbsoluteConstraints(20, 60, 143, -1));
        this.tServerPassword.addFocusListener(new FocusAdapter(){

            @Override
            public void focusLost(FocusEvent evt) {
                ServerGUI.this.tServerPasswordFocusLost(evt);
            }
        });
        this.tServerPassword.addKeyListener(new KeyAdapter(){

            @Override
            public void keyPressed(KeyEvent evt) {
                ServerGUI.this.tServerPasswordKeyPressed(evt);
            }
        });
        this.pGeneral.add((Component)this.tServerPassword, (Object)new AbsoluteConstraints(160, 55, 200, -1));
        this.sMaxPlayers.setModel(new SpinnerNumberModel(0, 0, 256, 1));
        this.sMaxPlayers.addFocusListener(new FocusAdapter(){

            @Override
            public void focusLost(FocusEvent evt) {
                ServerGUI.this.sMaxPlayersFocusLost(evt);
            }
        });
        this.sMaxPlayers.addKeyListener(new KeyAdapter(){

            @Override
            public void keyPressed(KeyEvent evt) {
                ServerGUI.this.sMaxPlayersKeyPressed(evt);
            }
        });
        this.pGeneral.add((Component)this.sMaxPlayers, (Object)new AbsoluteConstraints(160, 25, 73, -1));
        this.pTab3.add((Component)this.pGeneral, (Object)new AbsoluteConstraints(10, 10, 400, 120));
        this.pAdmins.setBorder(BorderFactory.createTitledBorder(null, "Admins", 0, 0, new Font("Tahoma", 1, 12)));
        this.pAdmins.setLayout((LayoutManager)new AbsoluteLayout());
        this.adminlist.setModel(this.adminListModel);
        this.adminlist_scrollpane.setViewportView(this.adminlist);
        this.pAdmins.add((Component)this.adminlist_scrollpane, (Object)new AbsoluteConstraints(10, 20, 530, 100));
        this.bAddAdmin.setText("Add");
        this.bAddAdmin.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ServerGUI.this.bAddAdminActionPerformed(evt);
            }
        });
        this.pAdmins.add((Component)this.bAddAdmin, (Object)new AbsoluteConstraints(10, 130, 170, -1));
        this.bRemoveAdmin.setText("Remove");
        this.bRemoveAdmin.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ServerGUI.this.bRemoveAdminActionPerformed(evt);
            }
        });
        this.pAdmins.add((Component)this.bRemoveAdmin, (Object)new AbsoluteConstraints(370, 130, 170, -1));
        this.pTab3.add((Component)this.pAdmins, (Object)new AbsoluteConstraints(10, 230, 550, 170));
        this.pPlayerMessage1.setBorder(BorderFactory.createTitledBorder(null, "Message", 0, 0, new Font("Tahoma", 1, 12)));
        this.pPlayerMessage1.setLayout((LayoutManager)new AbsoluteLayout());
        this.bSendText1.setText("Broadcast yell message");
        this.bSendText1.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ServerGUI.this.bSendText1ActionPerformed(evt);
            }
        });
        this.pPlayerMessage1.add((Component)this.bSendText1, (Object)new AbsoluteConstraints(10, 20, 170, -1));
        this.pTab3.add((Component)this.pPlayerMessage1, (Object)new AbsoluteConstraints(10, 400, 550, 60));
        this.tpMain.addTab("Server Control", this.pTab3);
        this.pTab4.setLayout((LayoutManager)new AbsoluteLayout());
        this.pPlayerInfos.setBorder(BorderFactory.createTitledBorder(null, "Information", 0, 0, new Font("Tahoma", 1, 12)));
        this.pPlayerInfos.setLayout((LayoutManager)new AbsoluteLayout());
        this.lPlayername.setFont(new Font("Tahoma", 1, 12));
        this.lPlayername.setText("Playername:");
        this.pPlayerInfos.add((Component)this.lPlayername, (Object)new AbsoluteConstraints(20, 30, 113, -1));
        this.lPlayernameValue.setText("N/A");
        this.pPlayerInfos.add((Component)this.lPlayernameValue, (Object)new AbsoluteConstraints(140, 30, 160, -1));
        this.lPosition.setFont(new Font("Tahoma", 1, 12));
        this.lPosition.setText("Position:");
        this.pPlayerInfos.add((Component)this.lPosition, (Object)new AbsoluteConstraints(20, 50, 113, -1));
        this.lHealth.setFont(new Font("Tahoma", 1, 12));
        this.lHealth.setText("Health:");
        this.pPlayerInfos.add((Component)this.lHealth, (Object)new AbsoluteConstraints(20, 70, 113, -1));
        this.lHunger.setFont(new Font("Tahoma", 1, 12));
        this.lHunger.setText("Hunger:");
        this.pPlayerInfos.add((Component)this.lHunger, (Object)new AbsoluteConstraints(20, 90, 113, -1));
        this.lPositionValue.setText("0.00 0.00 0.00");
        this.pPlayerInfos.add((Component)this.lPositionValue, (Object)new AbsoluteConstraints(140, 50, 160, -1));
        this.lHealthValue.setText("0");
        this.pPlayerInfos.add((Component)this.lHealthValue, (Object)new AbsoluteConstraints(140, 70, 160, -1));
        this.lHungerValue.setText("0");
        this.pPlayerInfos.add((Component)this.lHungerValue, (Object)new AbsoluteConstraints(140, 90, 160, -1));
        this.lIsAdmin.setFont(new Font("Tahoma", 1, 12));
        this.lIsAdmin.setForeground(new Color(255, 0, 0));
        this.lIsAdmin.setText("(ADMIN)");
        this.pPlayerInfos.add((Component)this.lIsAdmin, (Object)new AbsoluteConstraints(290, 30, 113, -1));
        this.lChunkpos.setFont(new Font("Tahoma", 1, 12));
        this.lChunkpos.setText("Chunkposition:");
        this.pPlayerInfos.add((Component)this.lChunkpos, (Object)new AbsoluteConstraints(290, 50, 113, -1));
        this.lThirst.setFont(new Font("Tahoma", 1, 12));
        this.lThirst.setText("Thirst:");
        this.pPlayerInfos.add((Component)this.lThirst, (Object)new AbsoluteConstraints(290, 90, 113, -1));
        this.lThirstValue.setText("0");
        this.pPlayerInfos.add((Component)this.lThirstValue, (Object)new AbsoluteConstraints(410, 90, 121, -1));
        this.lChunkposValue.setText("0 0 0");
        this.pPlayerInfos.add((Component)this.lChunkposValue, (Object)new AbsoluteConstraints(410, 50, 121, -1));
        this.pTab4.add((Component)this.pPlayerInfos, (Object)new AbsoluteConstraints(10, 10, 552, 127));
        this.pPlayerPosition.setBorder(BorderFactory.createTitledBorder(null, "Position", 0, 0, new Font("Tahoma", 1, 12)));
        this.pPlayerPosition.setLayout((LayoutManager)new AbsoluteLayout());
        this.bTeleport.setText("Teleport player");
        this.bTeleport.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ServerGUI.this.bTeleportActionPerformed(evt);
            }
        });
        this.pPlayerPosition.add((Component)this.bTeleport, (Object)new AbsoluteConstraints(10, 20, 167, -1));
        this.pTab4.add((Component)this.pPlayerPosition, (Object)new AbsoluteConstraints(10, 140, 552, 60));
        this.pPlayerStatus.setBorder(BorderFactory.createTitledBorder(null, "Status", 0, 0, new Font("Tahoma", 1, 12)));
        this.pPlayerStatus.setLayout((LayoutManager)new AbsoluteLayout());
        this.bSetHealth.setText("Set player health");
        this.bSetHealth.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ServerGUI.this.bSetHealthActionPerformed(evt);
            }
        });
        this.pPlayerStatus.add((Component)this.bSetHealth, (Object)new AbsoluteConstraints(10, 20, 167, -1));
        this.bSetHunger.setText("Set player hunger");
        this.bSetHunger.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ServerGUI.this.bSetHungerActionPerformed(evt);
            }
        });
        this.pPlayerStatus.add((Component)this.bSetHunger, (Object)new AbsoluteConstraints(10, 50, 167, -1));
        this.bSetThirst.setText("Set player thirst");
        this.bSetThirst.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ServerGUI.this.bSetThirstActionPerformed(evt);
            }
        });
        this.pPlayerStatus.add((Component)this.bSetThirst, (Object)new AbsoluteConstraints(190, 50, 167, -1));
        this.bHeal.setForeground(new Color(51, 153, 0));
        this.bHeal.setText("Heal player");
        this.bHeal.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ServerGUI.this.bHealActionPerformed(evt);
            }
        });
        this.pPlayerStatus.add((Component)this.bHeal, (Object)new AbsoluteConstraints(190, 20, 167, -1));
        this.pTab4.add((Component)this.pPlayerStatus, (Object)new AbsoluteConstraints(10, 200, 552, 100));
        this.pPlayerMessage.setBorder(BorderFactory.createTitledBorder(null, "Message", 0, 0, new Font("Tahoma", 1, 12)));
        this.pPlayerMessage.setLayout((LayoutManager)new AbsoluteLayout());
        this.bSendText.setText("Send text message");
        this.bSendText.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ServerGUI.this.bSendTextActionPerformed(evt);
            }
        });
        this.pPlayerMessage.add((Component)this.bSendText, (Object)new AbsoluteConstraints(10, 20, 167, -1));
        this.bSendYell.setText("Send yell message");
        this.bSendYell.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ServerGUI.this.bSendYellActionPerformed(evt);
            }
        });
        this.pPlayerMessage.add((Component)this.bSendYell, (Object)new AbsoluteConstraints(190, 20, 167, -1));
        this.pTab4.add((Component)this.pPlayerMessage, (Object)new AbsoluteConstraints(10, 300, 552, 60));
        this.pPlayerPunishment.setBorder(BorderFactory.createTitledBorder(null, "Punishment", 0, 0, new Font("Tahoma", 1, 12)));
        this.pPlayerPunishment.setLayout((LayoutManager)new AbsoluteLayout());
        this.bKick.setForeground(new Color(204, 0, 0));
        this.bKick.setText("Kick player");
        this.bKick.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ServerGUI.this.bKickActionPerformed(evt);
            }
        });
        this.pPlayerPunishment.add((Component)this.bKick, (Object)new AbsoluteConstraints(10, 20, 167, -1));
        this.bBan.setForeground(new Color(204, 0, 0));
        this.bBan.setText("Ban player");
        this.bBan.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ServerGUI.this.bBanActionPerformed(evt);
            }
        });
        this.pPlayerPunishment.add((Component)this.bBan, (Object)new AbsoluteConstraints(190, 20, 167, -1));
        this.bSlap.setForeground(new Color(204, 0, 0));
        this.bSlap.setText("Slap player");
        this.bSlap.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ServerGUI.this.bSlapActionPerformed(evt);
            }
        });
        this.pPlayerPunishment.add((Component)this.bSlap, (Object)new AbsoluteConstraints(370, 20, 167, -1));
        this.pTab4.add((Component)this.pPlayerPunishment, (Object)new AbsoluteConstraints(10, 360, 552, 60));
        // this.tpMain.addTab("Playercontrol", this.pTab4); // trevor
        this.pTab5.setLayout((LayoutManager)new AbsoluteLayout());
        this.pBannedPlayers.setBorder(BorderFactory.createTitledBorder(null, "Banned players", 0, 0, new Font("Tahoma", 1, 12)));
        this.pBannedPlayers.setLayout((LayoutManager)new AbsoluteLayout());
        this.banlist_scrollpane.setVerticalScrollBarPolicy(22);
        this.banlist.setModel(this.banListModel);
        this.banlist.setSelectionMode(0);
        this.banlist.addListSelectionListener(new ListSelectionListener(){

            @Override
            public void valueChanged(ListSelectionEvent evt) {
                ServerGUI.this.banlistValueChanged(evt);
            }
        });
        this.banlist_scrollpane.setViewportView(this.banlist);
        this.pBannedPlayers.add((Component)this.banlist_scrollpane, (Object)new AbsoluteConstraints(6, 17, 240, 400));
        this.bUnbanPlayer.setText("Unban player");
        this.bUnbanPlayer.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ServerGUI.this.bUnbanPlayerActionPerformed(evt);
            }
        });
        this.pBannedPlayers.add((Component)this.bUnbanPlayer, (Object)new AbsoluteConstraints(0, 420, 240, -1));
        this.pTab5.add((Component)this.pBannedPlayers, (Object)new AbsoluteConstraints(10, 10, 250, 460));
        this.pBanInfos.setBorder(BorderFactory.createTitledBorder(null, "Information", 0, 0, new Font("Tahoma", 1, 12)));
        this.pBanInfos.setLayout((LayoutManager)new AbsoluteLayout());
        this.lBannedby.setFont(new Font("Tahoma", 1, 12));
        this.lBannedby.setText("Banned by");
        this.pBanInfos.add((Component)this.lBannedby, (Object)new AbsoluteConstraints(10, 30, 191, -1));
        this.lBannedbyValue.setText("N/A");
        this.pBanInfos.add((Component)this.lBannedbyValue, (Object)new AbsoluteConstraints(20, 50, 262, -1));
        this.lBandate.setFont(new Font("Tahoma", 1, 12));
        this.lBandate.setText("Bandate");
        this.pBanInfos.add((Component)this.lBandate, (Object)new AbsoluteConstraints(10, 70, 191, -1));
        this.lBandateValue.setText("N/A");
        this.pBanInfos.add((Component)this.lBandateValue, (Object)new AbsoluteConstraints(20, 90, 262, -1));
        this.lBanneduntil.setFont(new Font("Tahoma", 1, 12));
        this.lBanneduntil.setText("Banned until");
        this.pBanInfos.add((Component)this.lBanneduntil, (Object)new AbsoluteConstraints(10, 110, 191, -1));
        this.lBanneduntilValue.setText("<html>N/A</html>");
        this.pBanInfos.add((Component)this.lBanneduntilValue, (Object)new AbsoluteConstraints(20, 130, 262, -1));
        this.lBanreason.setFont(new Font("Tahoma", 1, 12));
        this.lBanreason.setText("Reason");
        this.pBanInfos.add((Component)this.lBanreason, (Object)new AbsoluteConstraints(10, 150, 191, -1));
        this.lBanreasonValue.setText("N/A");
        this.lBanreasonValue.setVerticalAlignment(1);
        this.pBanInfos.add((Component)this.lBanreasonValue, (Object)new AbsoluteConstraints(20, 170, 270, 60));
        this.pTab5.add((Component)this.pBanInfos, (Object)new AbsoluteConstraints(260, 10, 304, 233));
        this.pBanPlayer.setBorder(BorderFactory.createTitledBorder(null, "Ban player", 0, 0, new Font("Tahoma", 1, 12)));
        this.pBanPlayer.setLayout((LayoutManager)new AbsoluteLayout());
        this.lBanPlayerName.setFont(new Font("Tahoma", 1, 12));
        this.lBanPlayerName.setText("Playername");
        this.pBanPlayer.add((Component)this.lBanPlayerName, (Object)new AbsoluteConstraints(10, 30, -1, -1));
        this.lBanPlayerDuration.setFont(new Font("Tahoma", 1, 12));
        this.lBanPlayerDuration.setText("Duration (minutes)");
        this.pBanPlayer.add((Component)this.lBanPlayerDuration, (Object)new AbsoluteConstraints(10, 80, 247, -1));
        this.lBanPlayerReason.setFont(new Font("Tahoma", 1, 12));
        this.lBanPlayerReason.setText("Reason");
        this.pBanPlayer.add((Component)this.lBanPlayerReason, (Object)new AbsoluteConstraints(10, 130, 247, -1));
        this.pBanPlayer.add((Component)this.tBanPlayerName, (Object)new AbsoluteConstraints(30, 50, 240, -1));
        this.pBanPlayer.add((Component)this.tBanPlayerReason, (Object)new AbsoluteConstraints(30, 150, 240, -1));
        this.sBanPlayerDuration.setModel(new SpinnerNumberModel(-1, -1, 9999999, 1));
        this.pBanPlayer.add((Component)this.sBanPlayerDuration, (Object)new AbsoluteConstraints(30, 100, 90, -1));
        this.lBanPlayerDurationHint.setText("(-1 for permanent ban)");
        this.pBanPlayer.add((Component)this.lBanPlayerDurationHint, (Object)new AbsoluteConstraints(130, 104, 160, -1));
        this.bBanPlayer.setText("Ban player");
        this.bBanPlayer.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ServerGUI.this.bBanPlayerActionPerformed(evt);
            }
        });
        this.pBanPlayer.add((Component)this.bBanPlayer, (Object)new AbsoluteConstraints(30, 180, 240, -1));
        this.pTab5.add((Component)this.pBanPlayer, (Object)new AbsoluteConstraints(258, 250, 304, 220));
        //this.tpMain.addTab("Banlist", this.pTab5); trevor
        this.pTab6.setLayout((LayoutManager)new AbsoluteLayout());
        this.customimages.setModel(this.customImageListModel);
        this.customimages.setSelectionMode(0);
        this.customimages.addListSelectionListener(new ListSelectionListener(){

            @Override
            public void valueChanged(ListSelectionEvent evt) {
                ServerGUI.this.customimagesValueChanged(evt);
            }
        });
        this.customimages.addKeyListener(new KeyAdapter(){

            @Override
            public void keyPressed(KeyEvent evt) {
                ServerGUI.this.customimagesKeyPressed(evt);
            }

            @Override
            public void keyReleased(KeyEvent evt) {
                ServerGUI.this.customimagesKeyReleased(evt);
            }

            @Override
            public void keyTyped(KeyEvent evt) {
                ServerGUI.this.customimagesKeyTyped(evt);
            }
        });
        this.customimages_scrollpane.setViewportView(this.customimages);
        this.pTab6.add((Component)this.customimages_scrollpane, (Object)new AbsoluteConstraints(10, 11, 210, 450));
        this.customimage_preview_bck.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        this.customimage_preview.setCursor(new Cursor(12));
        this.customimage_preview.addMouseListener(new MouseAdapter(){

            @Override
            public void mouseClicked(MouseEvent evt) {
                ServerGUI.this.customimage_previewMouseClicked(evt);
            }
        });
        GroupLayout customimage_preview_bckLayout = new GroupLayout(this.customimage_preview_bck);
        this.customimage_preview_bck.setLayout(customimage_preview_bckLayout);
        customimage_preview_bckLayout.setHorizontalGroup(customimage_preview_bckLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.customimage_preview, -1, 328, 32767));
        customimage_preview_bckLayout.setVerticalGroup(customimage_preview_bckLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.customimage_preview, -1, 328, 32767));
        this.pTab6.add((Component)this.customimage_preview_bck, (Object)new AbsoluteConstraints(230, 10, 330, 330));
        this.lImgName.setFont(new Font("Tahoma", 1, 12));
        this.lImgName.setText("Name:");
        this.pTab6.add((Component)this.lImgName, (Object)new AbsoluteConstraints(230, 350, 93, -1));
        this.lImgDate.setFont(new Font("Tahoma", 1, 12));
        this.lImgDate.setText("Date:");
        this.pTab6.add((Component)this.lImgDate, (Object)new AbsoluteConstraints(230, 390, 93, -1));
        this.lImgPlayer.setFont(new Font("Tahoma", 1, 12));
        this.lImgPlayer.setText("Player:");
        this.pTab6.add((Component)this.lImgPlayer, (Object)new AbsoluteConstraints(230, 410, 93, -1));
        this.bImgBanPlayer.setText("Ban player");
        this.bImgBanPlayer.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ServerGUI.this.bImgBanPlayerActionPerformed(evt);
            }
        });
        this.pTab6.add((Component)this.bImgBanPlayer, (Object)new AbsoluteConstraints(410, 440, 150, -1));
        this.lImgNameValue.setFont(new Font("Tahoma", 0, 12));
        this.lImgNameValue.setText("N/A");
        this.pTab6.add((Component)this.lImgNameValue, (Object)new AbsoluteConstraints(310, 350, 250, -1));
        this.lImgDateValue.setFont(new Font("Tahoma", 0, 12));
        this.lImgDateValue.setText("N/A");
        this.pTab6.add((Component)this.lImgDateValue, (Object)new AbsoluteConstraints(310, 390, 250, -1));
        this.lImgPlayerValue.setFont(new Font("Tahoma", 0, 12));
        this.lImgPlayerValue.setText("N/A");
        this.pTab6.add((Component)this.lImgPlayerValue, (Object)new AbsoluteConstraints(310, 410, 250, -1));
        this.lImgSize.setFont(new Font("Tahoma", 1, 12));
        this.lImgSize.setText("Size:");
        this.pTab6.add((Component)this.lImgSize, (Object)new AbsoluteConstraints(230, 370, 93, -1));
        this.lImgSizeValue.setFont(new Font("Tahoma", 0, 12));
        this.lImgSizeValue.setText("N/A");
        this.pTab6.add((Component)this.lImgSizeValue, (Object)new AbsoluteConstraints(310, 370, 250, -1));
        this.bDeleteImage.setText("Delete image");
        this.bDeleteImage.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                ServerGUI.this.bDeleteImageActionPerformed(evt);
            }
        });
        this.pTab6.add((Component)this.bDeleteImage, (Object)new AbsoluteConstraints(230, 440, 150, -1));
        // this.tpMain.addTab("Custom images", this.pTab6); trevor

        // Trevor's hackage
        this.pTab7.setLayout((LayoutManager)new AbsoluteLayout());
        this.lTrevTabTitle = new JLabel();
        this.lTrevTabTitle.setFont(new Font("Tahoma", 1, 12));
        this.lTrevTabTitle.setText(trevrconFeatures);
        this.pTab7.add((Component)this.lTrevTabTitle, (Object) new AbsoluteConstraints(20, 200, 300, -1));

        this.lAdminName = new JLabel("Admin Name:");
        this.pTab7.add((Component)this.lAdminName, (Object) new AbsoluteConstraints(10, 20, 100, -1));
        this.tAdminName = new JTextField(trevProp.getProperty("adminname"));
        this.pTab7.add((Component)this.tAdminName, (Object) new AbsoluteConstraints(130, 15, 200, -1));
        this.lAdminChatColor = new JLabel("Admin Chat Color:");
        this.pTab7.add((Component)this.lAdminChatColor, (Object) new AbsoluteConstraints(10, 45, 100, -1));
        this.tAdminChatColor = new JTextField(trevProp.getProperty("adminchatcolor"));
        this.pTab7.add((Component)this.tAdminChatColor, (Object) new AbsoluteConstraints(130, 40, 100, -1));
        this.lWordWrap = new JLabel("Word-wrap:");
        this.pTab7.add((Component)this.lWordWrap, (Object) new AbsoluteConstraints(10, 70, 100, -1));
        this.cWordWrap = new JCheckBox();
        cWordWrap.setSelected(Boolean.valueOf(trevProp.getProperty("wordwrap")));
        cWordWrap.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                JCheckBox cb = (JCheckBox) e.getSource();
                if (cb.isSelected())
                {
                    chat.setLineWrap(true);
                } else chat.setLineWrap(false);
                trevProp.setProperty("wordwrap", String.valueOf(wordwrap));
                writeConfigFile(trevProp);
            }
        });
        this.pTab7.add((Component)this.cWordWrap, (Object) new AbsoluteConstraints(130, 70, 20, -1));

        this.lGUIWidth = new JLabel("GUI Width");
        this.lGUIHeight = new JLabel("GUI Height");
        this.lGUIWidthTail = new JLabel("(min. 580)");
        this.lGUIHeightTail = new JLabel("(min. 480)");
        this.tGUIWidth = new JTextField(trevProp.getProperty("windowwidth"));
        this.tGUIHeight = new JTextField(trevProp.getProperty("windowheight"));
        this.bSaveSettings = new JButton("Save Settings");
        this.pTab7.add((Component)this.lGUIWidth, (Object) new AbsoluteConstraints(10, 95, 100, -1));
        this.pTab7.add((Component)this.lGUIHeight, (Object) new AbsoluteConstraints(10, 120, 100, -1));
        this.pTab7.add((Component)this.lGUIWidthTail, (Object) new AbsoluteConstraints(250, 95, 100, -1));
        this.pTab7.add((Component)this.lGUIHeightTail, (Object) new AbsoluteConstraints(250, 120, 100, -1));
        this.pTab7.add((Component)this.tGUIWidth, (Object) new AbsoluteConstraints(130, 90, 100, -1));
        this.pTab7.add((Component)this.tGUIHeight, (Object) new AbsoluteConstraints(130, 115, 100, -1));
        this.pTab7.add((Component)this.bSaveSettings, (Object) new AbsoluteConstraints(350, 115, 150, -1));
        bSaveSettings.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
                {
                    adminName = tAdminName.getText();
                    trevProp.setProperty("adminname", String.valueOf(adminName));
                    adminChatColor = tAdminChatColor.getText();
                    trevProp.setProperty("adminchatcolor", String.valueOf(adminChatColor));

                    windowWidth = Integer.valueOf(tGUIWidth.getText());
                    if(windowWidth < 580)
                    {
                        windowWidth = 580;
                        tGUIWidth.setText("580");
                    }
                    windowHeight = Integer.valueOf(tGUIHeight.getText());
                    if(windowWidth < 480)
                    {
                        windowWidth = 480;
                        tGUIWidth.setText("480");
                    }
                    // if gui size has been changed, notify user that a restart is required
                    if(!String.valueOf(windowWidth).equals(trevProp.getProperty("windowwidth"))
                    || !String.valueOf(windowHeight).equals(trevProp.getProperty("windowheight"))
                    ) JOptionPane.showMessageDialog((Component) null, "A restart is required.", "TrevoRCON", JOptionPane.WARNING_MESSAGE);
                    trevProp.setProperty("windowwidth", String.valueOf(windowWidth));
                    trevProp.setProperty("windowheight", String.valueOf(windowHeight));

                    writeConfigFile(trevProp);

                }
            }
        );

        this.tpMain.addTab("Trevor's Remix", this.pTab7);
        this.getContentPane().add((Component)this.tpMain, (Object)new AbsoluteConstraints(220, 10, -1, -1));
        this.setResizable(false);
        this.pack();
    }

    private void chat_inputKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.bChatSendActionPerformed(null);
        }
    }

    private void bChatSendActionPerformed(ActionEvent evt) {
        String text = this.chat_input.getText();
        this.chat_input.setText("");
        if (text != null && !text.isEmpty()) {
            // ChatPacket packet = new ChatPacket("[#FF0000]Admin", text);
            ChatPacket packet = new ChatPacket(adminChatColor + adminName, text);
            this.main.sendMessage(packet);
        }
    }

    private void bSaveallActionPerformed(ActionEvent evt) {
        SaveWorldPacket save = new SaveWorldPacket();
        this.main.sendMessage(save);
    }

    private void bShutdownActionPerformed(ActionEvent evt) {
        int n = JOptionPane.showConfirmDialog(null, "Are you sure you want to shutdown the server?", "Shutdown", 0, 2);
        if (n == 0) {
            ShutdownPacket shutdown = new ShutdownPacket();
            this.main.sendMessage(shutdown);
        }
    }

    private void bCleanupItemsActionPerformed(ActionEvent evt) {
        CleanUpServerPacket cleanup = new CleanUpServerPacket((byte)0);
        this.main.sendMessage(cleanup);
        JOptionPane.showMessageDialog(null, "All items have been removed!", "Cleanup", 1);
    }

    private void bCleanupCorpsesActionPerformed(ActionEvent evt) {
        CleanUpServerPacket cleanup = new CleanUpServerPacket((byte)1);
        this.main.sendMessage(cleanup);
        JOptionPane.showMessageDialog(null, "All corpses have been removed!", "Cleanup", 1);
    }

    private void bCleanupTreesActionPerformed(ActionEvent evt) {
        CleanUpServerPacket cleanup = new CleanUpServerPacket((byte)2);
        this.main.sendMessage(cleanup);
        JOptionPane.showMessageDialog(null, "All trees have been removed!", "Cleanup", 1);
    }

    private void playerlistValueChanged(ListSelectionEvent evt) {
        if (!evt.getValueIsAdjusting() && this.playerlist.getSelectedValue() != null) {
            String playername = (String)this.playerlist.getSelectedValue();
            RequestPlayerInfoPacket request = new RequestPlayerInfoPacket(playername);
            this.main.sendMessage(request);
        }
    }

    private void bAddAdminActionPerformed(ActionEvent evt) {
        String name = JOptionPane.showInputDialog(null, "Please enter a playername:", "Add admin", 3);
        if (name != null && !name.isEmpty() && !this.adminListModel.contains(name)) {
            System.out.println("Add admin: " + name);
            AddAdminPacket add = new AddAdminPacket(name);
            this.main.sendMessage(add);
        }
    }

    private void bRemoveAdminActionPerformed(ActionEvent evt) {
        List selection = this.adminlist.getSelectedValuesList();
        if (selection != null && !selection.isEmpty()) {
            /*
            for (String playername : selection) {
                int n = JOptionPane.showConfirmDialog(null, String.format("Are you sure you want to remove \"%s\" from admin list?", playername), "Remove admin", 0, 3);
                if (n != 0) continue;
                RemoveAdminPacket remove = new RemoveAdminPacket(playername);
                this.main.sendMessage(remove);
            }
            */
        }
    }

    private void tpMainStateChanged(ChangeEvent evt) {
        Component c = this.tpMain.getSelectedComponent();
        if (c == this.pTab3) {
            this.main.sendMessage(new RequestServerInfoPacket());
            this.main.sendMessage(new RequestAdminlistPacket());
        } else if (c == this.pTab4) {
            if (this.playerlist.getSelectedValue() != null) {
                String name = (String)this.playerlist.getSelectedValue();
                if (!name.isEmpty()) {
                    this.main.sendMessage(new RequestPlayerInfoPacket());
                }
            } else {
                this.guiUpdatePlayerInfo("N/A", false, "", "", (short)0, (short)0, (byte)0, (byte)0, false, false);
            }
        } else if (c == this.pTab5) {
            String txt = "N/A";
            this.lBandateValue.setText(txt);
            this.lBannedbyValue.setText(txt);
            this.lBanneduntilValue.setText(txt);
            this.lBanreasonValue.setText(txt);
            this.main.sendMessage(new RequestBanlistPacket());
        } else if (c == this.pTab6) {
            String txt = "N/A";
            this.lImgNameValue.setText(txt);
            this.lImgDateValue.setText(txt);
            this.lImgPlayerValue.setText(txt);
            this.lImgSizeValue.setText(txt);
            this.main.sendMessage(new RequestImagelistPacket());
        }
    }

    private void banlistValueChanged(ListSelectionEvent evt) {
        if (!evt.getValueIsAdjusting()) {
            String name = (String)this.banlist.getSelectedValue();
            if (this.bans != null) {
                for (String[] s : this.bans) {
                    if (!s[0].equals(name)) continue;
                    this.lBandateValue.setText(s[1]);
                    this.lBannedbyValue.setText(s[2]);
                    this.lBanneduntilValue.setText(s[3]);
                    this.lBanreasonValue.setText(s[4]);
                    return;
                }
            }
        }
    }

    private void playerlistMousePressed(MouseEvent evt) {
    }

    private void bEditServerTimeActionPerformed(ActionEvent evt) {
        String time = JOptionPane.showInputDialog(null, "Please enter the desired time (format HH or HH:MM)", "Change server time", 3);
        if (time != null && !time.isEmpty()) {
            String[] s;
            byte h = -1;
            byte m = -1;
            time = time.toLowerCase().replaceAll(" ", "");
            System.out.println("" + time);
            if (time.matches("[0-9]{1,2}")) {
                h = Byte.parseByte(time);
                m = 0;
            } else if (time.matches("[0-9]{1,2}:[0-9]{1,2}")) {
                s = time.split(":");
                h = Byte.parseByte(s[0]);
                m = Byte.parseByte(s[1]);
            } else if (time.matches("[0-9]{1,2}:[0-9]{1,2}((am)|(pm))")) {
                s = time.split(":");
                String ampm = time.substring(time.length() - 2);
                s[1] = s[1].substring(0, s[1].length() - 2);
                h = Byte.parseByte(s[0]);
                m = Byte.parseByte(s[1]);
                if (ampm.equalsIgnoreCase("pm")) {
                    h = (byte)(h + 12);
                }
            }
            if (h >= 0 && h < 24 && m >= 0 && m < 60) {
                SetServerTimePacket update = new SetServerTimePacket(h, m);
                this.main.sendMessage(update);
            } else {
                JOptionPane.showMessageDialog(null, "Invalid time format!", "Invalid time", 0);
            }
        }
    }

    private void bEditServerDateActionPerformed(ActionEvent evt) {
        String date = JOptionPane.showInputDialog(null, "Please enter the desired date (format MM/DD/YYYY)", "Change server date", 3);
        if (date != null && !date.isEmpty()) {
            byte d = -1;
            byte m = -1;
            int y = -1;
            if ((date = date.replaceAll(" ", "")).matches("[0-9]{1,2}/[0-9]{1,2}/[0-9]+")) {
                String[] s = date.split("/");
                m = Byte.parseByte(s[0]);
                d = Byte.parseByte(s[1]);
                y = Integer.parseInt(s[2]);
            }
            if (d > 0 && d < 32 && m > 0 && m < 13 && y >= 0) {
                SetServerDatePacket update = new SetServerDatePacket(d, m, y);
                this.main.sendMessage(update);
            } else {
                JOptionPane.showMessageDialog(null, "Invalid date format!", "Invalid date", 0);
            }
        }
    }

    private void bTeleportActionPerformed(ActionEvent evt) {
        if (this.playerlist.getSelectedValue() != null) {
            String playername = (String)this.playerlist.getSelectedValue();
            String pos = JOptionPane.showInputDialog(null, "Please enter the target position X Y Z", "Teleport " + playername, 3);
            if (pos != null && !pos.isEmpty()) {
                String[] p = pos.split(" ");
                if (p.length == 3 && p[0] != null && p[1] != null && p[2] != null && p[0].matches(NUMERIC_PATTERN) && p[1].matches(NUMERIC_PATTERN) && p[2].matches(NUMERIC_PATTERN)) {
                    float x = Float.parseFloat(p[0]);
                    float y = Float.parseFloat(p[1]);
                    float z = Float.parseFloat(p[2]);
                    TeleportPlayerPacket teleport = new TeleportPlayerPacket(playername, x, y, z);
                    this.main.sendMessage(teleport);
                    this.main.sendMessage(new RequestPlayerInfoPacket(playername));
                    return;
                }
                JOptionPane.showMessageDialog(null, "Wrong format! You need to specify the coordinates separated with a space (X Y Z)", "Teleport " + playername, 0);
            }
        }
    }

    private void bSetHealthActionPerformed(ActionEvent evt) {
        String playername;
        String s;
        if (this.playerlist.getSelectedValue() != null && !(playername = (String)this.playerlist.getSelectedValue()).isEmpty() && (s = JOptionPane.showInputDialog(null, "New health value:", "Change health for " + playername, 3)) != null && !s.isEmpty() && s.matches(NUMERIC_PATTERN)) {
            SetPlayerStatusPacket status = new SetPlayerStatusPacket();
            status.playername = playername;
            status.health = Short.parseShort(s);
            if (status.health < 0) {
                status.health = 0;
            }
            status.hunger = this.currentPlayerhunger;
            status.thirst = this.currentPlayerthirst;
            status.brokenbones = this.currentPlayerbrokenbones;
            this.main.sendMessage(status);
            this.main.sendMessage(new RequestPlayerInfoPacket(playername));
        }
    }

    private void bSetHungerActionPerformed(ActionEvent evt) {
        String playername;
        String s;
        if (this.playerlist.getSelectedValue() != null && !(playername = (String)this.playerlist.getSelectedValue()).isEmpty() && (s = JOptionPane.showInputDialog(null, "New hunger value:", "Change hunger for " + playername, 3)) != null && !s.isEmpty() && s.matches(NUMERIC_PATTERN)) {
            SetPlayerStatusPacket status = new SetPlayerStatusPacket();
            status.playername = playername;
            status.hunger = Byte.parseByte(s);
            if (status.hunger > 100) {
                status.hunger = (byte)100;
            } else if (status.hunger < 0) {
                status.hunger = 0;
            }
            status.health = this.currentPlayerhealth;
            status.thirst = this.currentPlayerthirst;
            status.brokenbones = this.currentPlayerbrokenbones;
            this.main.sendMessage(status);
            this.main.sendMessage(new RequestPlayerInfoPacket(playername));
        }
    }

    private void bSetThirstActionPerformed(ActionEvent evt) {
        String playername;
        String s;
        if (this.playerlist.getSelectedValue() != null && !(playername = (String)this.playerlist.getSelectedValue()).isEmpty() && (s = JOptionPane.showInputDialog(null, "New thirst value:", "Change thirst for " + playername, 3)) != null && !s.isEmpty() && s.matches(NUMERIC_PATTERN)) {
            SetPlayerStatusPacket status = new SetPlayerStatusPacket();
            status.playername = playername;
            status.thirst = Byte.parseByte(s);
            if (status.thirst > 100) {
                status.thirst = (byte)100;
            } else if (status.thirst < 0) {
                status.thirst = 0;
            }
            status.health = this.currentPlayerhealth;
            status.hunger = this.currentPlayerhunger;
            status.brokenbones = this.currentPlayerbrokenbones;
            this.main.sendMessage(status);
            this.main.sendMessage(new RequestPlayerInfoPacket(playername));
        }
    }

    private void bHealActionPerformed(ActionEvent evt) {
        String playername;
        if (this.playerlist.getSelectedValue() != null && !(playername = (String)this.playerlist.getSelectedValue()).isEmpty()) {
            SetPlayerStatusPacket status = new SetPlayerStatusPacket(playername, (short)100, (byte)100, (byte)100, false);
            this.main.sendMessage(status);
            this.main.sendMessage(new RequestPlayerInfoPacket(playername));
            JOptionPane.showMessageDialog(null, "Player healed", "Heal " + playername, 1);
        }
    }

    private void bSendTextActionPerformed(ActionEvent evt) {
        if (this.playerlist.getSelectedValue() != null) {
            String playername = (String)this.playerlist.getSelectedValue();
            String message = JOptionPane.showInputDialog(null, "", "Send text message to " + playername, 1);
            if (message != null && !message.isEmpty()) {
                PrivateChatPacket msg = new PrivateChatPacket(playername, "[#FF0000]Admin", message);
                this.main.sendMessage(msg);
                this.guiAddChatMessage(String.format("[PM to %s]: %s", playername, message));
            }
        }
    }

    private void bSendYellActionPerformed(ActionEvent evt) {
        if (this.playerlist.getSelectedValue() != null) {
            String playername = (String)this.playerlist.getSelectedValue();
            String message = JOptionPane.showInputDialog(null, "", "Send yell message to " + playername, 1);
            if (message != null && !message.isEmpty()) {
                PrivateYellPacket msg = new PrivateYellPacket(playername, message);
                this.main.sendMessage(msg);
                this.guiAddChatMessage(String.format("[Yell to %s]: %s", playername, message));
            }
        }
    }

    private void bKickActionPerformed(ActionEvent evt) {
        if (this.playerlist.getSelectedValue() != null) {
            String playername = (String)this.playerlist.getSelectedValue();
            String reason = JOptionPane.showInputDialog(null, "Please enter a reason for the kick:", "Kick " + playername, 3);
            if (reason != null && !reason.isEmpty()) {
                KickPlayerPacket kick = new KickPlayerPacket(playername, reason);
                this.main.sendMessage(kick);
            }
        }
    }

    private void bBanActionPerformed(ActionEvent evt) {
        if (this.playerlist.getSelectedValue() != null) {
            String playername = (String)this.playerlist.getSelectedValue();
            this.tpMain.setSelectedComponent(this.pTab5);
            this.tBanPlayerName.setText(playername);
            this.tBanPlayerReason.requestFocusInWindow();
        }
    }

    private void bSlapActionPerformed(ActionEvent evt) {
        String playername;
        if (this.playerlist.getSelectedValue() != null && !(playername = (String)this.playerlist.getSelectedValue()).isEmpty()) {
            SlapPlayerPacket slap = new SlapPlayerPacket(playername, 20);
            this.main.sendMessage(slap);
            this.main.sendMessage(new RequestPlayerInfoPacket(playername));
        }
    }

    private void bBanPlayerActionPerformed(ActionEvent evt) {
        int n;
        String playername = this.tBanPlayerName.getText();
        int duration = (Integer)this.sBanPlayerDuration.getValue();
        String reason = this.tBanPlayerReason.getText();
        if (reason == null || reason.isEmpty()) {
            reason = "N/A";
        }
        if (playername != null && !playername.isEmpty() && !this.banListModel.contains(playername) && (n = JOptionPane.showConfirmDialog(null, String.format("Do you really want to ban \"%s\"?", playername), "Ban player", 0, 3)) == 0) {
            BanPlayerPacket ban = new BanPlayerPacket(playername, duration, reason);
            this.main.sendMessage(ban);
        }
        this.tBanPlayerName.setText("");
        this.tBanPlayerReason.setText("");
    }

    private void bUnbanPlayerActionPerformed(ActionEvent evt) {
        int n;
        String playername;
        if (this.banlist.getSelectedValue() != null && (n = JOptionPane.showConfirmDialog(null, String.format("Do you really want to unban \"%s\"?", playername = (String)this.banlist.getSelectedValue()), "Unban player", 0, 3)) == 0) {
            UnbanPlayerPacket unban = new UnbanPlayerPacket(playername);
            this.main.sendMessage(unban);
        }
    }

    private void customimagesKeyTyped(KeyEvent evt) {
        evt.consume();
    }

    private void customimagesKeyPressed(KeyEvent evt) {
        if (this.pressed) {
            evt.consume();
        }
        this.pressed = true;
    }

    private void customimagesKeyReleased(KeyEvent evt) {
        this.pressed = false;
    }

    private void customimagesValueChanged(ListSelectionEvent evt) {
        String value;
        if (!evt.getValueIsAdjusting() && this.customimages.getSelectedValue() != null && (value = (String)this.customimages.getSelectedValue()).length() > CUSTOMIMGAGE_NAMEPREFIX.length()) {
            int id = Integer.parseInt(value.substring(CUSTOMIMGAGE_NAMEPREFIX.length()));
            ImageIcon icon = this.customImages.get(id);
            if (icon != null) {
                this.customimage_preview.setIcon(icon);
                this.customimage_preview.repaint();
            }
            RequestImageInfoPacket img = new RequestImageInfoPacket(id, icon == null, (Integer)Options.settings_imagesize.value);
            this.main.sendMessage(img);
        }
    }

    private void customimage_previewMouseClicked(MouseEvent evt) {
        int id;
        BufferedImage buff;
        String value;
        if (this.customimages.getSelectedValue() != null && (value = (String)this.customimages.getSelectedValue()).length() > CUSTOMIMGAGE_NAMEPREFIX.length() && (buff = this.customImagesBuff.get(id = Integer.parseInt(value.substring(CUSTOMIMGAGE_NAMEPREFIX.length())))) != null) {
            ImageView imageView = new ImageView(this, value, true, buff);
            imageView.setVisible(true);
        }
    }

    private void bDeleteImageActionPerformed(ActionEvent evt) {
        String value;
        if (this.customimages.getSelectedValue() != null && (value = (String)this.customimages.getSelectedValue()).length() > CUSTOMIMGAGE_NAMEPREFIX.length()) {
            int id = Integer.parseInt(value.substring(CUSTOMIMGAGE_NAMEPREFIX.length()));
            DeleteImagePacket delete = new DeleteImagePacket(id);
            this.main.sendMessage(delete);
            RequestImagelistPacket request = new RequestImagelistPacket();
            this.main.sendMessage(request);
        }
    }

    private void bImgBanPlayerActionPerformed(ActionEvent evt) {
        String playername = this.lImgPlayerValue.getText();
        if (!playername.isEmpty() && !playername.equals("N/A")) {
            this.tpMain.setSelectedComponent(this.pTab5);
            this.tBanPlayerName.setText(playername);
            this.tBanPlayerReason.requestFocusInWindow();
        }
    }

    private void sMaxPlayersFocusLost(FocusEvent evt) {
        SetServerMaxPlayersPacket set = new SetServerMaxPlayersPacket((Integer)this.sMaxPlayers.getValue());
        System.out.println("Set max players: " + set.maxplayers);
        this.main.sendMessage(set);
    }

    private void sMaxPlayersKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.sMaxPlayersFocusLost(null);
            evt.consume();
        }
    }

    private void tServerPasswordFocusLost(FocusEvent evt) {
        SetServerPasswordPacket set = new SetServerPasswordPacket(this.tServerPassword.getText());
        System.out.println("Set password: " + set.password);
        this.main.sendMessage(set);
    }

    private void tServerPasswordKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.tServerPasswordFocusLost(null);
            evt.consume();
        }
    }

    private void bSendText1ActionPerformed(ActionEvent evt) {

        JFrame frame = new JFrame();
        String title = "Broadcast Yell Message";
        String message = JOptionPane.showInputDialog(frame, title);
        if (message != null && !message.isEmpty()) {
            YellPacket msg = new YellPacket(message);
            this.main.sendMessage(msg);
        }
    }

    private void loadTrevorsProperties()
    {
        verNum = "0.1.1";
        trevProp = new Properties();
        // test for existence of setting.properties file, write a new one if needed
        File configFile = new File("trevorcon.properties");
        if (!configFile.exists())
        {
            writeConfigFile(getDefaultConfig());
        }
        // load in the new config
        InputStream input = null;
        FileInputStream in;
        try {
            input = new FileInputStream(configFile);
            trevProp.load(input);
        }
        catch (IOException e) {
            e.printStackTrace();
        } finally
        {
            if (input != null)
            {
                try
                {
                    input.close();
                } catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
        wordwrap = Boolean.parseBoolean(trevProp.getProperty("wordwrap"));
        adminName = String.valueOf(trevProp.getProperty("adminname"));
        adminChatColor = String.valueOf(trevProp.getProperty("adminchatcolor"));
        windowWidth = Integer.valueOf(trevProp.getProperty("windowwidth"));
        windowHeight = Integer.valueOf(trevProp.getProperty("windowheight"));

        chatWindowWidth = windowWidth - 20;
        chatWindowHeight = windowHeight - 50;

        chatInputWidth = windowWidth - 180;
        chatInputY = windowHeight - 50;

        chatSendX = windowWidth - 150;
        chatSendY = windowHeight - 50;
        chatSendWidth = 140;
        chatSendHeight = 26;

        trevrconFeatures = "<HTML>" +
                "Features:<BR>" +
                "* Chat pausing<BR>" +
                "* Word-wrap<BR>" +
                "* Customisable admin name<BR>" +
                "* Customisable admin chat color<BR>" +
                "* Resizable<BR>" +
                "* Save settings<BR>" +
                "* Disabled non-functional features<BR>" +
                "* Fixed server yell button" +
                "</HTML>";
    }

    private static Properties getDefaultConfig()
    {
        Properties p = new Properties();
        p.setProperty("wordwrap", "true");
        p.setProperty("adminname", "Admin");
        p.setProperty("adminchatcolor", "[#FF0000]");
        p.setProperty("windowwidth", "580");
        p.setProperty("windowheight", "480");
        return p;
    }

    private static void writeConfigFile(Properties properties)
    {
        boolean success = false;
        try {
            File file = new File("trevorcon.properties");
            FileOutputStream out = new FileOutputStream(file);
            properties.store(out,"");
            out.close();
            success = true;
        } catch (IOException e) { e.printStackTrace(); }
    }

}

