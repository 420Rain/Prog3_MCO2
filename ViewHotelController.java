import java.awt.event.*;

public class ViewHotelController {
    
    private ViewHotelModel vhModel;
    private ViewHotelView vhView;

    public ViewHotelController(ViewHotelModel vhModel, ViewHotelView vhView) {
        this.vhModel = vhModel;
        this.vhView = vhView;

        this.vhView.setRoomAvailBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vhView.showView("availView");
            }
        });

        this.vhView.setRoomDetailBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });

        this.vhView.setReservationsBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });

        this.vhView.setBackBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vhView.dispose();
            }
        });

        this.vhView.setReturnBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vhView.showView("mainView");
            }
        });
    }
}