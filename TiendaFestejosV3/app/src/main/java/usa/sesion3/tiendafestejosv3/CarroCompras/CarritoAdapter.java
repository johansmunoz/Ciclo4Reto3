/**package usa.sesion3.tiendafestejosv3.CarroCompras;

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
import usa.sesion3.tiendafestejosv3.Vista.Servicios;

public class CarritoAdapter extends BaseAdapter {
    Context context;
    ArrayList<ProductosCarrito> productosCarritos;

    LayoutInflater inflater;

    public CarritoAdapter(Context context, ArrayList<ProductosCarrito> productosCarritos) {
        this.context = context;
        this.productosCarritos = productosCarritos;
    }

    @Override
    public int getCount() {
        return productosCarritos.size();
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
            convertView = inflater.inflate(R.layout.grid_item, null);//tener en cuenta que dpto
            //se esta generando una redundancia
        }

        ImageView imageView = convertView.findViewById(R.id.grid_image);
        TextView textView = convertView.findViewById(R.id.grid_name);

        ProductosCarrito productosCarrito = productosCarritos.get(position);
        byte[] image = productosCarrito.getImage();
        Bitmap bitmap = BitmapFactory.decodeByteArray(image, 0,image.length);

        imageView.setImageBitmap(bitmap);
        textView.setText(productosCarrito.getTitulo());
        textView.setText(productosCarrito.getDescripcion());


        return convertView;
    }
}*/
