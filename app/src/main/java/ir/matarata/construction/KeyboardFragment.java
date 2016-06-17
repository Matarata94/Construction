package ir.matarata.construction;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 */
public class KeyboardFragment extends Fragment {

    private Button one_btn;
    private Button two_btn;
    private Button three_btn;
    private Button four_btn;
    private Button five_btn;
    private Button six_btn;
    private Button seven_btn;
    private Button eight_btn;
    private Button nine_btn;
    private Button zero_btn;
    private Button dot_btn;
    private Button back_btn;
    private Button forward_btn;
    private Button backward_btn;
    private Button done_btn;

    public static StringBuilder sb;

    private int maxLength=10000;
    public static int currentLength;

    private SectionDetailsFragment secdet = new SectionDetailsFragment();

    public KeyboardFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        sb=new StringBuilder(getArguments().getString("et_value"));
        currentLength=sb.length();
        View rootView=inflater.inflate(R.layout.keyboard, container, false);
        one_btn=(Button)rootView.findViewById(R.id.keyboard_btn1);
        one_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add("1");
            }
        });
        two_btn=(Button)rootView.findViewById(R.id.keyboard_btn2);
        two_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add("2");
            }
        });
        three_btn=(Button)rootView.findViewById(R.id.keyboard_btn3);
        three_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add("3");
            }
        });
        four_btn=(Button)rootView.findViewById(R.id.keyboard_btn4);
        four_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add("4");
            }
        });
        five_btn=(Button)rootView.findViewById(R.id.keyboard_btn5);
        five_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add("5");
            }
        });
        six_btn=(Button)rootView.findViewById(R.id.keyboard_btn6);
        six_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add("6");
            }
        });
        seven_btn=(Button)rootView.findViewById(R.id.keyboard_btn7);
        seven_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add("7");
            }
        });
        eight_btn=(Button)rootView.findViewById(R.id.keyboard_btn8);
        eight_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add("8");
            }
        });
        nine_btn=(Button)rootView.findViewById(R.id.keyboard_btn9);
        nine_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add("9");
            }
        });
        zero_btn=(Button)rootView.findViewById(R.id.keyboard_btn0);
        zero_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                    add("0");
            }
        });
        dot_btn=(Button)rootView.findViewById(R.id.keyboard_btndot);
        dot_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(sb.length()>0)
                    add(".");
            }
        });
        back_btn=(Button)rootView.findViewById(R.id.keyboard_btnremove);
        back_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(sb.length()>0)
                {
                    currentLength--;
                    if(secdet.meth.hasFocus()){
                        int cursorPosition = SectionDetailsFragment.meth.getSelectionStart();
                        if(cursorPosition != 0) {
                            sb.deleteCharAt(cursorPosition - 1);
                            SectionDetailsFragment.meth.setText(sb.toString());
                            SectionDetailsFragment.meth.setSelection(cursorPosition-1);
                        }
                    }else if(secdet.metb.hasFocus()) {
                        int cursorPosition = SectionDetailsFragment.metb.getSelectionStart();
                        if(cursorPosition != 0) {
                            sb.deleteCharAt(cursorPosition - 1);
                            SectionDetailsFragment.metb.setText(sb.toString());
                            SectionDetailsFragment.metb.setSelection(cursorPosition-1);
                        }
                    }else if(secdet.spdownarm.hasFocus()) {
                        int cursorPosition = SectionDetailsFragment.spdownarm.getSelectionStart();
                        if(cursorPosition != 0) {
                            sb.deleteCharAt(cursorPosition - 1);
                            SectionDetailsFragment.spdownarm.setText(sb.toString());
                            SectionDetailsFragment.spdownarm.setSelection(cursorPosition-1);
                        }
                    }else if(secdet.spdownarmnumber.hasFocus()) {
                        int cursorPosition = SectionDetailsFragment.spdownarmnumber.getSelectionStart();
                        if(cursorPosition != 0) {
                            sb.deleteCharAt(cursorPosition - 1);
                            SectionDetailsFragment.spdownarmnumber.setText(sb.toString());
                            SectionDetailsFragment.spdownarmnumber.setSelection(cursorPosition-1);
                        }
                    }else if(secdet.spdownarmcover.hasFocus()) {
                        int cursorPosition = SectionDetailsFragment.spdownarmcover.getSelectionStart();
                        if(cursorPosition != 0) {
                            sb.deleteCharAt(cursorPosition - 1);
                            SectionDetailsFragment.spdownarmcover.setText(sb.toString());
                            SectionDetailsFragment.spdownarmcover.setSelection(cursorPosition-1);
                        }
                    }else if(secdet.spuparm.hasFocus()) {
                        int cursorPosition = SectionDetailsFragment.spuparm.getSelectionStart();
                        if(cursorPosition != 0) {
                            sb.deleteCharAt(cursorPosition - 1);
                            SectionDetailsFragment.spuparm.setText(sb.toString());
                            SectionDetailsFragment.spuparm.setSelection(cursorPosition-1);
                        }
                    }else if(secdet.spuparmnumber.hasFocus()) {
                        int cursorPosition = SectionDetailsFragment.spuparmnumber.getSelectionStart();
                        if(cursorPosition != 0) {
                            sb.deleteCharAt(cursorPosition - 1);
                            SectionDetailsFragment.spuparmnumber.setText(sb.toString());
                            SectionDetailsFragment.spuparmnumber.setSelection(cursorPosition-1);
                        }
                    }else if(secdet.spuparmcover.hasFocus()) {
                        int cursorPosition = SectionDetailsFragment.spuparmcover.getSelectionStart();
                        if(cursorPosition != 0) {
                            sb.deleteCharAt(cursorPosition - 1);
                            SectionDetailsFragment.spuparmcover.setText(sb.toString());
                            SectionDetailsFragment.spuparmcover.setSelection(cursorPosition-1);
                        }
                    }else if(secdet.spties.hasFocus()) {
                        int cursorPosition = SectionDetailsFragment.spties.getSelectionStart();
                        if(cursorPosition != 0) {
                            sb.deleteCharAt(cursorPosition - 1);
                            SectionDetailsFragment.spties.setText(sb.toString());
                            SectionDetailsFragment.spties.setSelection(cursorPosition-1);
                        }
                    }else if(secdet.sptiesnumber.hasFocus()) {
                        int cursorPosition = SectionDetailsFragment.sptiesnumber.getSelectionStart();
                        if(cursorPosition != 0) {
                            sb.deleteCharAt(cursorPosition - 1);
                            SectionDetailsFragment.sptiesnumber.setText(sb.toString());
                            SectionDetailsFragment.sptiesnumber.setSelection(cursorPosition-1);
                        }
                    }else if(secdet.sptiescover.hasFocus()) {
                        int cursorPosition = SectionDetailsFragment.sptiescover.getSelectionStart();
                        if(cursorPosition != 0) {
                            sb.deleteCharAt(cursorPosition - 1);
                            SectionDetailsFragment.sptiescover.setText(sb.toString());
                            SectionDetailsFragment.sptiescover.setSelection(cursorPosition-1);
                        }
                    }else if(secdet.metfc.hasFocus()) {
                        int cursorPosition = SectionDetailsFragment.metfc.getSelectionStart();
                        if(cursorPosition != 0) {
                            sb.deleteCharAt(cursorPosition - 1);
                            SectionDetailsFragment.metfc.setText(sb.toString());
                            SectionDetailsFragment.metfc.setSelection(cursorPosition-1);
                        }
                    }else if(secdet.metfy.hasFocus()) {
                        int cursorPosition = SectionDetailsFragment.metfy.getSelectionStart();
                        if(cursorPosition != 0) {
                            sb.deleteCharAt(cursorPosition - 1);
                            SectionDetailsFragment.metfy.setText(sb.toString());
                            SectionDetailsFragment.metfy.setSelection(cursorPosition-1);
                        }
                    }
                }
            }
        });
        back_btn.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View v) {
                currentLength=0;
                if(secdet.meth.hasFocus()){
                    sb = new StringBuilder();
                    SectionDetailsFragment.meth.setText(sb.toString());
                    SectionDetailsFragment.meth.setSelection(0);
                }else if(secdet.metb.hasFocus()) {
                    sb = new StringBuilder();
                    SectionDetailsFragment.metb.setText(sb.toString());
                    SectionDetailsFragment.metb.setSelection(0);
                }else if(secdet.spdownarm.hasFocus()) {
                    sb = new StringBuilder();
                    SectionDetailsFragment.spdownarm.setText(sb.toString());
                    SectionDetailsFragment.spdownarm.setSelection(0);
                }else if(secdet.spdownarmnumber.hasFocus()) {
                    sb = new StringBuilder();
                    SectionDetailsFragment.spdownarmnumber.setText(sb.toString());
                    SectionDetailsFragment.spdownarmnumber.setSelection(0);
                }else if(secdet.spdownarmcover.hasFocus()) {
                    sb = new StringBuilder();
                    SectionDetailsFragment.spdownarmcover.setText(sb.toString());
                    SectionDetailsFragment.spdownarmcover.setSelection(0);
                }else if(secdet.spuparm.hasFocus()) {
                    sb = new StringBuilder();
                    SectionDetailsFragment.spuparm.setText(sb.toString());
                    SectionDetailsFragment.spuparm.setSelection(0);
                }else if(secdet.spuparmnumber.hasFocus()) {
                    sb = new StringBuilder();
                    SectionDetailsFragment.spuparmnumber.setText(sb.toString());
                    SectionDetailsFragment.spuparmnumber.setSelection(0);
                }else if(secdet.spuparmcover.hasFocus()) {
                    sb = new StringBuilder();
                    SectionDetailsFragment.spuparmcover.setText(sb.toString());
                    SectionDetailsFragment.spuparmcover.setSelection(0);
                }else if(secdet.spties.hasFocus()) {
                    sb = new StringBuilder();
                    SectionDetailsFragment.spties.setText(sb.toString());
                    SectionDetailsFragment.spties.setSelection(0);
                }else if(secdet.sptiesnumber.hasFocus()) {
                    sb = new StringBuilder();
                    SectionDetailsFragment.sptiesnumber.setText(sb.toString());
                    SectionDetailsFragment.sptiesnumber.setSelection(0);
                }else if(secdet.sptiescover.hasFocus()) {
                    sb = new StringBuilder();
                    SectionDetailsFragment.sptiescover.setText(sb.toString());
                    SectionDetailsFragment.sptiescover.setSelection(0);
                }else if(secdet.metfc.hasFocus()) {
                    sb = new StringBuilder();
                    SectionDetailsFragment.metfc.setText(sb.toString());
                    SectionDetailsFragment.metfc.setSelection(0);
                }else if(secdet.metfy.hasFocus()) {
                    sb = new StringBuilder();
                    SectionDetailsFragment.metfy.setText(sb.toString());
                    SectionDetailsFragment.metfy.setSelection(0);
                }
                return false;
            }
        });
        forward_btn=(Button)rootView.findViewById(R.id.keyboard_btnforeward);
        forward_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        backward_btn=(Button)rootView.findViewById(R.id.keyboard_btnbackward);
        backward_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        done_btn=(Button)rootView.findViewById(R.id.keyboard_btnkeyboard);
        done_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(SectionDetailsFragment.keyboard_fragment.isVisible()) {
                    getActivity().getSupportFragmentManager().beginTransaction().remove(SectionDetailsFragment.keyboard_fragment).commit();
                    SectionDetailsFragment.keyboard_fragment = null;
                }
            }
        });
        return rootView;
    }

    public void add(String num)
    {
        currentLength++;
        if(currentLength<=maxLength)
        {
            if(secdet.meth.hasFocus()){
                int cursorPosition = SectionDetailsFragment.meth.getSelectionStart();
                sb.insert(cursorPosition,num);
                SectionDetailsFragment.meth.setText(sb.toString());
                SectionDetailsFragment.meth.setSelection(cursorPosition+1);
            }else if(secdet.metb.hasFocus()) {
                int cursorPosition = SectionDetailsFragment.metb.getSelectionStart();
                sb.insert(cursorPosition,num);
                SectionDetailsFragment.metb.setText(sb.toString());
                SectionDetailsFragment.metb.setSelection(cursorPosition+1);
            }else if(secdet.spdownarm.hasFocus()) {
                int cursorPosition = SectionDetailsFragment.spdownarm.getSelectionStart();
                sb.insert(cursorPosition,num);
                SectionDetailsFragment.spdownarm.setText(sb.toString());
                SectionDetailsFragment.spdownarm.setSelection(cursorPosition+1);
            }else if(secdet.spdownarmnumber.hasFocus()) {
                int cursorPosition = SectionDetailsFragment.spdownarmnumber.getSelectionStart();
                sb.insert(cursorPosition,num);
                SectionDetailsFragment.spdownarmnumber.setText(sb.toString());
                SectionDetailsFragment.spdownarmnumber.setSelection(cursorPosition+1);
            }else if(secdet.spdownarmcover.hasFocus()) {
                int cursorPosition = SectionDetailsFragment.spdownarmcover.getSelectionStart();
                sb.insert(cursorPosition,num);
                SectionDetailsFragment.spdownarmcover.setText(sb.toString());
                SectionDetailsFragment.spdownarmcover.setSelection(cursorPosition+1);
            }else if(secdet.spuparm.hasFocus()) {
                int cursorPosition = SectionDetailsFragment.spuparm.getSelectionStart();
                sb.insert(cursorPosition,num);
                SectionDetailsFragment.spuparm.setText(sb.toString());
                SectionDetailsFragment.spuparm.setSelection(cursorPosition+1);
            }else if(secdet.spuparmnumber.hasFocus()) {
                int cursorPosition = SectionDetailsFragment.spuparmnumber.getSelectionStart();
                sb.insert(cursorPosition,num);
                SectionDetailsFragment.spuparmnumber.setText(sb.toString());
                SectionDetailsFragment.spuparmnumber.setSelection(cursorPosition+1);
            }else if(secdet.spuparmcover.hasFocus()) {
                int cursorPosition = SectionDetailsFragment.spuparmcover.getSelectionStart();
                sb.insert(cursorPosition,num);
                SectionDetailsFragment.spuparmcover.setText(sb.toString());
                SectionDetailsFragment.spuparmcover.setSelection(cursorPosition+1);
            }else if(secdet.spties.hasFocus()) {
                int cursorPosition = SectionDetailsFragment.spties.getSelectionStart();
                sb.insert(cursorPosition,num);
                SectionDetailsFragment.spties.setText(sb.toString());
                SectionDetailsFragment.spties.setSelection(cursorPosition+1);
            }else if(secdet.sptiesnumber.hasFocus()) {
                int cursorPosition = SectionDetailsFragment.sptiesnumber.getSelectionStart();
                sb.insert(cursorPosition,num);
                SectionDetailsFragment.sptiesnumber.setText(sb.toString());
                SectionDetailsFragment.sptiesnumber.setSelection(cursorPosition+1);
            }else if(secdet.sptiescover.hasFocus()) {
                int cursorPosition = SectionDetailsFragment.sptiescover.getSelectionStart();
                sb.insert(cursorPosition,num);
                SectionDetailsFragment.sptiescover.setText(sb.toString());
                SectionDetailsFragment.sptiescover.setSelection(cursorPosition+1);
            }else if(secdet.metfc.hasFocus()) {
                int cursorPosition = SectionDetailsFragment.metfc.getSelectionStart();
                sb.insert(cursorPosition,num);
                SectionDetailsFragment.metfc.setText(sb.toString());
                SectionDetailsFragment.metfc.setSelection(cursorPosition+1);
            }else if(secdet.metfy.hasFocus()) {
                int cursorPosition = SectionDetailsFragment.metfy.getSelectionStart();
                sb.insert(cursorPosition,num);
                SectionDetailsFragment.metfy.setText(sb.toString());
                SectionDetailsFragment.metfy.setSelection(cursorPosition+1);
            }
        }
        else
            currentLength--;
    }

    public static KeyboardFragment newInstance(String EditTextValue)
    {
        KeyboardFragment fragment=new KeyboardFragment();
        Bundle bundle=new Bundle();
        bundle.putString("et_value", EditTextValue);
        fragment.setArguments(bundle);
        return fragment;
    }

}
