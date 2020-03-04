package co.chatsdk.ui.views;

import android.content.Context;
import android.text.Html;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.github.siyamed.shapeimageview.mask.PorterShapeImageView;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.chatsdk.ui.R;
import co.chatsdk.ui.R2;
import co.chatsdk.ui.icons.Icons;

public class ReplyView extends ConstraintLayout {

    @BindView(R2.id.imageView)
    PorterShapeImageView imageView;
    @BindView(R2.id.divider)
    View divider;
    @BindView(R2.id.replyTextView)
    TextView replyTextView;
    @BindView(R2.id.cancelButton)
    ImageButton cancelButton;
    @BindView(R2.id.root)
    ConstraintLayout root;

    public ReplyView(Context context) {
        super(context);
        initViews();
    }

    public ReplyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initViews();
    }

    public ReplyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initViews();
    }

    protected void initViews() {
        LayoutInflater.from(getContext()).inflate(R.layout.view_chat_reply, this, true);
        ButterKnife.bind(this);

        cancelButton.setImageDrawable(Icons.get(Icons.choose().cancel, R.color.gray_light));
        hide();
    }

    public void show(String title, String imageURL, String text) {
        setVisibility(View.VISIBLE);

        if (imageURL != null && !imageURL.isEmpty()) {
            imageView.setVisibility(View.VISIBLE);
            Picasso.get().load(imageURL).into(imageView);
        } else {
            imageView.setVisibility(View.GONE);
        }
        if (text != null) {
            replyTextView.setText(Html.fromHtml("<b>" + title + "</b><br/>" + text));
        }
    }

    public void hide() {
        setVisibility(View.GONE);
    }

    public boolean isVisible() {
        return getVisibility() == View.VISIBLE;
    }

    public void setOnCancelListener(OnClickListener listener) {
        cancelButton.setOnClickListener(listener);
    }

}
