package software.ulpgc.imageviewerMVC;

import software.ulpgc.imageviewerMVC.control.Command;
import software.ulpgc.imageviewerMVC.control.NextCommand;
import software.ulpgc.imageviewerMVC.model.Image;
import software.ulpgc.imageviewerMVC.view.ImageDisplay;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class MainFrame extends JFrame {
    private Map<String, Command> commands;
    private ImageDisplay display;

    public MainFrame() throws HeadlessException {
        this.commands = new HashMap<>();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().add(components());
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setBackground(Color.BLACK);
        pack();
        createCommands();

    }

    private JPanel components() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(toolbar(), BorderLayout.SOUTH);
        panel.add(panelImage(),BorderLayout.CENTER);
        return panel;
    }

    private ImagePanel panelImage() {
        ImagePanel panel = new ImagePanel(firstImage());
        this.display = panel;
        return panel;
    }

    private Image firstImage() {
        FileReader fileReader = new FileReader("imagenes");
        return fileReader.read();
    }

    private void createCommands() {
        commands.put("Next", new NextCommand(display));
        commands.put("Prev", new NextCommand(display));
    }

    private JPanel toolbar(){
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel.add(prevButton());
        panel.add(nextButton());
        return panel;
    }

    private JButton nextButton() {
        JButton button = new JButton("Next");
        button.addActionListener(makeCommand("Next"));
        return button;
    }

    private JButton prevButton() {
        JButton button = new JButton("Prev");
        button.addActionListener(makeCommand("Prev"));
        return button;
    }

    private ActionListener makeCommand(String command) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                commands.get(command).execute();
            }
        };
    }
}
