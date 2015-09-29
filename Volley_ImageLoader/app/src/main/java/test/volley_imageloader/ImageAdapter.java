package test.volley_imageloader;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;

import java.util.List;

import test.volley_imageloader.model.ImageListModel;

/**
 * Created by shimoju_k on 2015/09/28.
 */
public class ImageAdapter extends ArrayAdapter<ImageListModel> {

    private LayoutInflater mInflater;
    private ImageLoader mLoader;

    public ImageAdapter(Context context, int resource, List<ImageListModel> imageList) {

        super(context, resource, imageList);
        mInflater = LayoutInflater.from(context);
        mLoader = ((AppController)((MainActivity)context).getApplication()).mImageLoader;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        ImageListModel model = getItem(position);

        if (null == convertView) {
            convertView = mInflater.inflate(R.layout.line_layout, parent, false);
            holder = new ViewHolder();
            holder.image = (ImageView)convertView.findViewById(R.id.img_awn);
            holder.name = (TextView)convertView.findViewById(R.id.txt_name);
        } else {
            holder = (ViewHolder)convertView.getTag();
        }

        ImageLoader.ImageContainer imageContainer = (ImageLoader.ImageContainer)holder.image.getTag();
        if (imageContainer != null) {
            imageContainer.cancelRequest();
        }

        ImageLoader.ImageListener listener = ImageLoader.getImageListener(holder.image, R.drawable.load, R.drawable.error);

        holder.image.setTag(mLoader.get(model.getImageUrl(), listener));
        holder.name.setText(model.getName());

        convertView.setTag(holder);

        return convertView;
    }

    private static class ViewHolder {
        ImageView image;
        TextView name;
    }
}
