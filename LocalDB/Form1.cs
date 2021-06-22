using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace LocalDB
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void dataBindingNavigatorSaveItem_Click(object sender, EventArgs e)
        {
         

        }

        private void dataBindingNavigatorSaveItem_Click_1(object sender, EventArgs e)
        {
          
        }

        private void dataBindingNavigatorSaveItem_Click_2(object sender, EventArgs e)
        {
           
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            // TODO: This line of code loads data into the 'projectDataSet.Parts' table. You can move, or remove it, as needed.
            this.partsTableAdapter.Fill(this.projectDataSet.Parts);
            // TODO: This line of code loads data into the 'myDataset.Data' table. You can move, or remove it, as needed.
          


        }

        private void dataDataGridView_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {

        }

        private void dataBindingNavigatorSaveItem_Click_3(object sender, EventArgs e)
        {
           
        }

        private void partsBindingNavigatorSaveItem_Click(object sender, EventArgs e)
        {
            this.Validate();
            this.partsBindingSource.EndEdit();
            this.tableAdapterManager.UpdateAll(this.projectDataSet);

        }
    }
}
