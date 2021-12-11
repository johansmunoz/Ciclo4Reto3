package usa.sesion3.tiendafestejosv3.Vista;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import usa.sesion3.tiendafestejosv3.R;

public class ServiciosAdapter extends BaseAdapter {
    Context context;
    ArrayList<Servicios> listaServicios;

    LayoutInflater inflater;

    public ServiciosAdapter(Context context, ArrayList<Servicios> listaServicios) {
        this.context = context;
        this.listaServicios = listaServicios;
    }

    @Override
    public int getCount() {
        return listaServicios.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(inflater == null){
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if(convertView == null){
            convertView = inflater.inflate(R.layout.grid_item, null);
        }

        ImageView imageView = convertView.findViewById(R.id.grid_image);
        TextView textView = convertView.findViewById(R.id.grid_name);

        Servicios servicios = listaServicios.get(position);
        byte[] image = servicios.getImage();
        Bitmap bitmap = BitmapFactory.decodeByteArray(image, 0,image.length);

        imageView.setImageBitmap(bitmap);
        textView.setText(servicios.getName());


        return convertView;
    }
}
