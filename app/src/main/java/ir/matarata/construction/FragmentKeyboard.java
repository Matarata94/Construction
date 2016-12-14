package ir.matarata.construction;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentKeyboard extends Fragment {

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

    private FragmentSectionDetails secdet = new FragmentSectionDetails();

    public FragmentKeyboard() {
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
                        int cursorPosition = FragmentSectionDetails.meth.getSelectionStart();
                        if(cursorPosition != 0) {
                            sb.deleteCharAt(cursorPosition - 1);
                            FragmentSectionDetails.meth.setText(sb.toString());
                            FragmentSectionDetails.meth.setSelection(cursorPosition-1);
                        }
                    }else if(secdet.metb.hasFocus()) {
                        int cursorPosition = FragmentSectionDetails.metb.getSelectionStart();
                        if(cursorPosition != 0) {
                            sb.deleteCharAt(cursorPosition - 1);
                            FragmentSectionDetails.metb.setText(sb.toString());
                            FragmentSectionDetails.metb.setSelection(cursorPosition-1);
                        }
                    }else if(secdet.spdownarm.hasFocus()) {
                        int cursorPosition = FragmentSectionDetails.spdownarm.getSelectionStart();
                        if(cursorPosition != 0) {
                            sb.deleteCharAt(cursorPosition - 1);
                            FragmentSectionDetails.spdownarm.setText(sb.toString());
                            FragmentSectionDetails.spdownarm.setSelection(cursorPosition-1);
                        }
                    }else if(secdet.spdownarmnumber.hasFocus()) {
                        int cursorPosition = FragmentSectionDetails.spdownarmnumber.getSelectionStart();
                        if(cursorPosition != 0) {
                            sb.deleteCharAt(cursorPosition - 1);
                            FragmentSectionDetails.spdownarmnumber.setText(sb.toString());
                            FragmentSectionDetails.spdownarmnumber.setSelection(cursorPosition-1);
                        }
                    }else if(secdet.spdownarmcover.hasFocus()) {
                        int cursorPosition = FragmentSectionDetails.spdownarmcover.getSelectionStart();
                        if(cursorPosition != 0) {
                            sb.deleteCharAt(cursorPosition - 1);
                            FragmentSectionDetails.spdownarmcover.setText(sb.toString());
                            FragmentSectionDetails.spdownarmcover.setSelection(cursorPosition-1);
                        }
                    }else if(secdet.spuparm.hasFocus()) {
                        int cursorPosition = FragmentSectionDetails.spuparm.getSelectionStart();
                        if(cursorPosition != 0) {
                            sb.deleteCharAt(cursorPosition - 1);
                            FragmentSectionDetails.spuparm.setText(sb.toString());
                            FragmentSectionDetails.spuparm.setSelection(cursorPosition-1);
                        }
                    }else if(secdet.spuparmnumber.hasFocus()) {
                        int cursorPosition = FragmentSectionDetails.spuparmnumber.getSelectionStart();
                        if(cursorPosition != 0) {
                            sb.deleteCharAt(cursorPosition - 1);
                            FragmentSectionDetails.spuparmnumber.setText(sb.toString());
                            FragmentSectionDetails.spuparmnumber.setSelection(cursorPosition-1);
                        }
                    }else if(secdet.spuparmcover.hasFocus()) {
                        int cursorPosition = FragmentSectionDetails.spuparmcover.getSelectionStart();
                        if(cursorPosition != 0) {
                            sb.deleteCharAt(cursorPosition - 1);
                            FragmentSectionDetails.spuparmcover.setText(sb.toString());
                            FragmentSectionDetails.spuparmcover.setSelection(cursorPosition-1);
                        }
                    }else if(secdet.spties.hasFocus()) {
                        int cursorPosition = FragmentSectionDetails.spties.getSelectionStart();
                        if(cursorPosition != 0) {
                            sb.deleteCharAt(cursorPosition - 1);
                            FragmentSectionDetails.spties.setText(sb.toString());
                            FragmentSectionDetails.spties.setSelection(cursorPosition-1);
                        }
                    }else if(secdet.sptiesnumber.hasFocus()) {
                        int cursorPosition = FragmentSectionDetails.sptiesnumber.getSelectionStart();
                        if(cursorPosition != 0) {
                            sb.deleteCharAt(cursorPosition - 1);
                            FragmentSectionDetails.sptiesnumber.setText(sb.toString());
                            FragmentSectionDetails.sptiesnumber.setSelection(cursorPosition-1);
                        }
                    }else if(secdet.sptiescover.hasFocus()) {
                        int cursorPosition = FragmentSectionDetails.sptiescover.getSelectionStart();
                        if(cursorPosition != 0) {
                            sb.deleteCharAt(cursorPosition - 1);
                            FragmentSectionDetails.sptiescover.setText(sb.toString());
                            FragmentSectionDetails.sptiescover.setSelection(cursorPosition-1);
                        }
                    }else if(secdet.metfc.hasFocus()) {
                        int cursorPosition = FragmentSectionDetails.metfc.getSelectionStart();
                        if(cursorPosition != 0) {
                            sb.deleteCharAt(cursorPosition - 1);
                            FragmentSectionDetails.metfc.setText(sb.toString());
                            FragmentSectionDetails.metfc.setSelection(cursorPosition-1);
                        }
                    }else if(secdet.metfy.hasFocus()) {
                        int cursorPosition = FragmentSectionDetails.metfy.getSelectionStart();
                        if(cursorPosition != 0) {
                            sb.deleteCharAt(cursorPosition - 1);
                            FragmentSectionDetails.metfy.setText(sb.toString());
                            FragmentSectionDetails.metfy.setSelection(cursorPosition-1);
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
                    FragmentSectionDetails.meth.setText(sb.toString());
                    FragmentSectionDetails.meth.setSelection(0);
                }else if(secdet.metb.hasFocus()) {
                    sb = new StringBuilder();
                    FragmentSectionDetails.metb.setText(sb.toString());
                    FragmentSectionDetails.metb.setSelection(0);
                }else if(secdet.spdownarm.hasFocus()) {
                    sb = new StringBuilder();
                    FragmentSectionDetails.spdownarm.setText(sb.toString());
                    FragmentSectionDetails.spdownarm.setSelection(0);
                }else if(secdet.spdownarmnumber.hasFocus()) {
                    sb = new StringBuilder();
                    FragmentSectionDetails.spdownarmnumber.setText(sb.toString());
                    FragmentSectionDetails.spdownarmnumber.setSelection(0);
                }else if(secdet.spdownarmcover.hasFocus()) {
                    sb = new StringBuilder();
                    FragmentSectionDetails.spdownarmcover.setText(sb.toString());
                    FragmentSectionDetails.spdownarmcover.setSelection(0);
                }else if(secdet.spuparm.hasFocus()) {
                    sb = new StringBuilder();
                    FragmentSectionDetails.spuparm.setText(sb.toString());
                    FragmentSectionDetails.spuparm.setSelection(0);
                }else if(secdet.spuparmnumber.hasFocus()) {
                    sb = new StringBuilder();
                    FragmentSectionDetails.spuparmnumber.setText(sb.toString());
                    FragmentSectionDetails.spuparmnumber.setSelection(0);
                }else if(secdet.spuparmcover.hasFocus()) {
                    sb = new StringBuilder();
                    FragmentSectionDetails.spuparmcover.setText(sb.toString());
                    FragmentSectionDetails.spuparmcover.setSelection(0);
                }else if(secdet.spties.hasFocus()) {
                    sb = new StringBuilder();
                    FragmentSectionDetails.spties.setText(sb.toString());
                    FragmentSectionDetails.spties.setSelection(0);
                }else if(secdet.sptiesnumber.hasFocus()) {
                    sb = new StringBuilder();
                    FragmentSectionDetails.sptiesnumber.setText(sb.toString());
                    FragmentSectionDetails.sptiesnumber.setSelection(0);
                }else if(secdet.sptiescover.hasFocus()) {
                    sb = new StringBuilder();
                    FragmentSectionDetails.sptiescover.setText(sb.toString());
                    FragmentSectionDetails.sptiescover.setSelection(0);
                }else if(secdet.metfc.hasFocus()) {
                    sb = new StringBuilder();
                    FragmentSectionDetails.metfc.setText(sb.toString());
                    FragmentSectionDetails.metfc.setSelection(0);
                }else if(secdet.metfy.hasFocus()) {
                    sb = new StringBuilder();
                    FragmentSectionDetails.metfy.setText(sb.toString());
                    FragmentSectionDetails.metfy.setSelection(0);
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
                if(FragmentSectionDetails.keyboard_fragment.isVisible()) {
                    getActivity().getSupportFragmentManager().beginTransaction().remove(FragmentSectionDetails.keyboard_fragment).commit();
                    FragmentSectionDetails.keyboard_fragment = null;
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
                int cursorPosition = FragmentSectionDetails.meth.getSelectionStart();
                sb.insert(cursorPosition,num);
                FragmentSectionDetails.meth.setText(sb.toString());
                FragmentSectionDetails.meth.setSelection(cursorPosition+1);
            }else if(secdet.metb.hasFocus()) {
                int cursorPosition = FragmentSectionDetails.metb.getSelectionStart();
                sb.insert(cursorPosition,num);
                FragmentSectionDetails.metb.setText(sb.toString());
                FragmentSectionDetails.metb.setSelection(cursorPosition+1);
            }else if(secdet.spdownarm.hasFocus()) {
                int cursorPosition = FragmentSectionDetails.spdownarm.getSelectionStart();
                sb.insert(cursorPosition,num);
                FragmentSectionDetails.spdownarm.setText(sb.toString());
                FragmentSectionDetails.spdownarm.setSelection(cursorPosition+1);
            }else if(secdet.spdownarmnumber.hasFocus()) {
                int cursorPosition = FragmentSectionDetails.spdownarmnumber.getSelectionStart();
                sb.insert(cursorPosition,num);
                FragmentSectionDetails.spdownarmnumber.setText(sb.toString());
                FragmentSectionDetails.spdownarmnumber.setSelection(cursorPosition+1);
            }else if(secdet.spdownarmcover.hasFocus()) {
                int cursorPosition = FragmentSectionDetails.spdownarmcover.getSelectionStart();
                sb.insert(cursorPosition,num);
                FragmentSectionDetails.spdownarmcover.setText(sb.toString());
                FragmentSectionDetails.spdownarmcover.setSelection(cursorPosition+1);
            }else if(secdet.spuparm.hasFocus()) {
                int cursorPosition = FragmentSectionDetails.spuparm.getSelectionStart();
                sb.insert(cursorPosition,num);
                FragmentSectionDetails.spuparm.setText(sb.toString());
                FragmentSectionDetails.spuparm.setSelection(cursorPosition+1);
            }else if(secdet.spuparmnumber.hasFocus()) {
                int cursorPosition = FragmentSectionDetails.spuparmnumber.getSelectionStart();
                sb.insert(cursorPosition,num);
                FragmentSectionDetails.spuparmnumber.setText(sb.toString());
                FragmentSectionDetails.spuparmnumber.setSelection(cursorPosition+1);
            }else if(secdet.spuparmcover.hasFocus()) {
                int cursorPosition = FragmentSectionDetails.spuparmcover.getSelectionStart();
                sb.insert(cursorPosition,num);
                FragmentSectionDetails.spuparmcover.setText(sb.toString());
                FragmentSectionDetails.spuparmcover.setSelection(cursorPosition+1);
            }else if(secdet.spties.hasFocus()) {
                int cursorPosition = FragmentSectionDetails.spties.getSelectionStart();
                sb.insert(cursorPosition,num);
                FragmentSectionDetails.spties.setText(sb.toString());
                FragmentSectionDetails.spties.setSelection(cursorPosition+1);
            }else if(secdet.sptiesnumber.hasFocus()) {
                int cursorPosition = FragmentSectionDetails.sptiesnumber.getSelectionStart();
                sb.insert(cursorPosition,num);
                FragmentSectionDetails.sptiesnumber.setText(sb.toString());
                FragmentSectionDetails.sptiesnumber.setSelection(cursorPosition+1);
            }else if(secdet.sptiescover.hasFocus()) {
                int cursorPosition = FragmentSectionDetails.sptiescover.getSelectionStart();
                sb.insert(cursorPosition,num);
                FragmentSectionDetails.sptiescover.setText(sb.toString());
                FragmentSectionDetails.sptiescover.setSelection(cursorPosition+1);
            }else if(secdet.metfc.hasFocus()) {
                int cursorPosition = FragmentSectionDetails.metfc.getSelectionStart();
                sb.insert(cursorPosition,num);
                FragmentSectionDetails.metfc.setText(sb.toString());
                FragmentSectionDetails.metfc.setSelection(cursorPosition+1);
            }else if(secdet.metfy.hasFocus()) {
                int cursorPosition = FragmentSectionDetails.metfy.getSelectionStart();
                sb.insert(cursorPosition,num);
                FragmentSectionDetails.metfy.setText(sb.toString());
                FragmentSectionDetails.metfy.setSelection(cursorPosition+1);
            }
        }
        else
            currentLength--;
    }

    public static FragmentKeyboard newInstance(String EditTextValue)
    {
        FragmentKeyboard fragment=new FragmentKeyboard();
        Bundle bundle=new Bundle();
        bundle.putString("et_value", EditTextValue);
        fragment.setArguments(bundle);
        return fragment;
    }

}
