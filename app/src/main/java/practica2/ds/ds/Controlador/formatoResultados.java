package practica2.ds.ds.Controlador;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import practica2.ds.ds.BaseDeDatos.TablaResultados;
import practica2.ds.ds.R;

/**
 * Created by Pablo on 12/05/2015.
 */
public class formatoResultados extends BaseAdapter{
        public ArrayList<TablaResultados> list;
        Activity activity;

        public formatoResultados(Activity activity, ArrayList < TablaResultados > list) {
            super();
            this.activity = activity;
            this.list = list;
        }

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            // TODO Auto-generated method stub
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            // TODO Auto-generated method stub
            return 0;
        }

        private class ViewHolder {
            TextView txtFirst;
            TextView txtSecond;
            TextView txtThird;
            TextView txtFourth;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // TODO Auto-generated method stub

            // TODO Auto-generated method stub
            ViewHolder holder;
            LayoutInflater inflater =  activity.getLayoutInflater();

            if (convertView == null)
            {
                convertView = inflater.inflate(R.layout.formato_resultados, null);
                holder = new ViewHolder();
                holder.txtFirst = (TextView) convertView.findViewById(R.id.FirstText);
                holder.txtSecond = (TextView) convertView.findViewById(R.id.SecondText);
                holder.txtThird = (TextView) convertView.findViewById(R.id.ThirdText);
                holder.txtFourth = (TextView) convertView.findViewById(R.id.FourthText);
                convertView.setTag(holder);
            }
            else
            {
                holder = (ViewHolder) convertView.getTag();
            }

            TablaResultados map = list.get(position);
            holder.txtFirst.setText(map.fecha);
            holder.txtSecond.setText(map.actividad);
            holder.txtThird.setText(""+map.aciertos);
            holder.txtFourth.setText(""+map.fallos);

            return convertView;
        }
}
