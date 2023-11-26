/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Views.GUI;

import Model.Individuals.CityTileset;
import Model.Inicializer.RandomCityInicializer;

/**
 *
 * @author gabriel
 */
public class CityParametersView extends javax.swing.JPanel {

    /**
     * Creates new form CityParametersView
     */
    public CityParametersView() {
        initComponents();
        
        CitySlide.setLimits(CityTileset.MAXSIZE, CityTileset.MINSIZE);
        CitySlide.setDefault(CityTileset.DEFAULTSIZE);
        roadDensitySlide.setLimits(RandomCityInicializer.MAXROADDENSITY, RandomCityInicializer.MINROADDENSITY);
        roadDensitySlide.setDefault(RandomCityInicializer.DEFROADDENSITY);
        buildingDensitySlider.setLimits(RandomCityInicializer.MAXBUILDINGDENSITY,RandomCityInicializer.MINBUILDINGDENSITY);
        buildingDensitySlider.setDefault(RandomCityInicializer.DEFBUILDINGDENSITY);
    }
    
    public int getCitySizeValue(){
        return CitySlide.getValue();
    }
    
    public int getRoadDensity(){
        return roadDensitySlide.getValue();
    }
    
    public int getBuildingDensity(){
        return buildingDensitySlider.getValue();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buildingDensityLabel = new javax.swing.JLabel();
        roadDensityLabel = new javax.swing.JLabel();
        CitySizeLabel = new javax.swing.JLabel();
        CitySlide = new Views.GUI.SlideBar();
        roadDensitySlide = new Views.GUI.SlideBar();
        buildingDensitySlider = new Views.GUI.SlideBar();
        jSeparator1 = new javax.swing.JSeparator();

        buildingDensityLabel.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        buildingDensityLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        buildingDensityLabel.setText("Building Density");

        roadDensityLabel.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        roadDensityLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        roadDensityLabel.setText("Road Density");

        CitySizeLabel.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        CitySizeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CitySizeLabel.setText("City Size");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(roadDensityLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CitySizeLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buildingDensityLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE))
                .addGap(8, 8, 8)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CitySlide, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                    .addComponent(roadDensitySlide, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                    .addComponent(buildingDensitySlider, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(CitySizeLabel))
                    .addComponent(CitySlide, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(roadDensitySlide, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(roadDensityLabel)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(buildingDensitySlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(buildingDensityLabel)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jSeparator1)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CitySizeLabel;
    private Views.GUI.SlideBar CitySlide;
    private javax.swing.JLabel buildingDensityLabel;
    private Views.GUI.SlideBar buildingDensitySlider;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel roadDensityLabel;
    private Views.GUI.SlideBar roadDensitySlide;
    // End of variables declaration//GEN-END:variables
}
