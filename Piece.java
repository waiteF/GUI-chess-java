import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;

public  class Piece {
    JButton button;
    private boolean white;
    private char type;

    public Piece(JButton button, boolean white, char type) {
        this.button=button;
        this.white=white;
        this.type=type;
        this.setImage();
    }

    public Piece(JButton button, char type){
        this.button=button;
        this.type=type;
        this.setImage();
    }

    public void setPiece(char type,boolean white) {
        this.type = type;
        this.white=white;
        this.setImage();
    }

    public void setPiece(char type) {
        this.type = type;
        this.setImage();
    }

    public boolean isWhite() {
        return white;
    }

    public void setWhite(boolean white) {
        this.white = white;
    }

    public JButton getButton() {
        return button;
    }

    public void setButton(JButton button) {
        this.button = button;
    }

    public char getType() {
        return type;
    }



    public void movementP(Piece[][] matrix,int i, int j,boolean turno){

        if(matrix[i][j].isWhite() && turno){
            matrix[i][j].getButton().setBackground(Color.PINK);

            if(i==6){
                if(matrix[i-1][j].getType()=='s'){
                    matrix[i-1][j].getButton().setBackground(Color.ORANGE);
                    if(matrix[i-2][j].getType()=='s')
                        matrix[i-2][j].getButton().setBackground(Color.ORANGE);
                }
            }
            else{
                if(i>0){
                    if(matrix[i-1][j].getType()=='s')
                        matrix[i-1][j].getButton().setBackground(Color.ORANGE);
                }
            }

            if(i>0 && j>0){
                if(!matrix[i-1][j-1].isWhite() && matrix[i-1][j-1].getType()!='s')
                    matrix[i-1][j-1].getButton().setBackground(Color.ORANGE);
            }

            if(i>0 && j<7) {
                if (!matrix[i-1][j+1].isWhite() && matrix[i-1][j+1].getType()!='s')
                    matrix[i-1][j+1].getButton().setBackground(Color.ORANGE);
            }
        }
        else if(!matrix[i][j].isWhite() && !turno){
            matrix[i][j].getButton().setBackground(Color.PINK);

            if(i==1){
                if(matrix[i+1][j].getType()=='s'){
                    matrix[i+1][j].getButton().setBackground(Color.ORANGE);
                    if(matrix[i+2][j].getType()=='s')
                        matrix[i+2][j].getButton().setBackground(Color.ORANGE);
                }
            }
            else{
                if(i<7){
                    if(matrix[i+1][j].getType()=='s')
                        matrix[i+1][j].getButton().setBackground(Color.ORANGE);
                }
            }

            if(i<7 && j<7){
                if(matrix[i+1][j+1].isWhite() && matrix[i+1][j+1].getType()!='s')
                    matrix[i+1][j+1].getButton().setBackground(Color.ORANGE);
            }

            if(i<7 && j>0){
                if(matrix[i+1][j-1].isWhite() && matrix[i+1][j-1].getType()!='s')
                    matrix[i+1][j-1].getButton().setBackground(Color.ORANGE);
            }
        }
    }


    public void movementR(Piece[][] matrix,int i, int j,boolean turno){
        int cnt;
        boolean brk=true;


        if(matrix[i][j].isWhite() && turno) {

            matrix[i][j].getButton().setBackground(Color.PINK);
            cnt = i+1;
            while (cnt < 8 && brk) {
                if (matrix[cnt][j].getType()!='s') {
                    if(matrix[cnt][j].isWhite()) {
                        brk=false;
                    }
                    else {
                        matrix[cnt][j].getButton().setBackground(Color.ORANGE);
                        brk=false;
                    }
                }
                else if(matrix[cnt][j].getType()=='s') {
                    matrix[cnt][j].getButton().setBackground(Color.ORANGE);
                }
                cnt++;
            }

            brk=true;
            cnt = i-1;
            while (cnt >= 0 && brk) {
                if (matrix[cnt][j].getType()!='s') {
                    if(matrix[cnt][j].isWhite()) {
                        brk=false;
                    }
                    else {
                        matrix[cnt][j].getButton().setBackground(Color.ORANGE);
                        brk=false;
                    }
                }
                else if(matrix[cnt][j].getType()=='s') {
                    matrix[cnt][j].getButton().setBackground(Color.ORANGE);
                }
                cnt--;
            }

            brk=true;
            cnt = j+1;
            while (cnt < 8 && brk) {
                if (matrix[i][cnt].getType()!='s') {
                    if(matrix[i][cnt].isWhite()) {
                        brk=false;
                    }
                    else {
                        matrix[i][cnt].getButton().setBackground(Color.ORANGE);
                        brk=false;
                    }
                }
                else if(matrix[i][cnt].getType()=='s') {
                    matrix[i][cnt].getButton().setBackground(Color.ORANGE);
                }
                cnt++;
            }

            brk=true;
            cnt = j-1;
            while (cnt >= 0 && brk) {
                if (matrix[i][cnt].getType()!='s') {
                    if(matrix[i][cnt].isWhite()) {
                        brk=false;
                    }
                    else {
                        matrix[i][cnt].getButton().setBackground(Color.ORANGE);
                        brk=false;
                    }
                }
                else if(matrix[i][cnt].getType()=='s') {
                    matrix[i][cnt].getButton().setBackground(Color.ORANGE);
                }
                cnt--;
            }

        }
        else if(!matrix[i][j].isWhite() && !turno ){
            matrix[i][j].getButton().setBackground(Color.PINK);
            cnt = i+1;
            while (cnt < 8 && brk) {
                if (matrix[cnt][j].getType()!='s') {
                    if(!matrix[cnt][j].isWhite()) {
                        brk=false;
                    }
                    else {
                        matrix[cnt][j].getButton().setBackground(Color.ORANGE);
                        brk=false;
                    }
                }
                else if(matrix[cnt][j].getType()=='s') {
                    matrix[cnt][j].getButton().setBackground(Color.ORANGE);
                }
                cnt++;
            }

            brk=true;
            cnt = i-1;
            while (cnt >= 0 && brk) {
                if (matrix[cnt][j].getType()!='s') {
                    if(!matrix[cnt][j].isWhite()) {
                        brk=false;
                    }
                    else {
                        matrix[cnt][j].getButton().setBackground(Color.ORANGE);
                        brk=false;

                    }

                }
                else if(matrix[cnt][j].getType()=='s') {
                    matrix[cnt][j].getButton().setBackground(Color.ORANGE);
                }
                cnt--;
            }

            brk=true;
            cnt = j+1;
            while (cnt < 8 && brk) {
                if (matrix[i][cnt].getType()!='s') {
                    if(!matrix[i][cnt].isWhite()) {
                        brk=false;
                    }
                    else {
                        matrix[i][cnt].getButton().setBackground(Color.ORANGE);
                        brk=false;
                    }
                }
                else if(matrix[i][cnt].getType()=='s') {
                    matrix[i][cnt].getButton().setBackground(Color.ORANGE);
                }
                cnt++;
            }

            brk=true;
            cnt = j-1;
            while (cnt >= 0 && brk) {
                if (matrix[i][cnt].getType()!='s') {
                    if(!matrix[i][cnt].isWhite()) {
                        brk=false;
                    }
                    else {
                        matrix[i][cnt].getButton().setBackground(Color.ORANGE);
                        brk=false;

                    }

                }
                else if(matrix[i][cnt].getType()=='s') {
                    matrix[i][cnt].getButton().setBackground(Color.ORANGE);
                }
                cnt--;
            }
        }
    }


    public void movementH(Piece[][] matrix,int i, int j,boolean turno){

        if(matrix[i][j].isWhite() && turno) {
            matrix[i][j].getButton().setBackground(Color.PINK);

            if(i>1 && j<7){
                if(matrix[i-2][j+1].getType()=='s'){
                    matrix[i-2][j+1].getButton().setBackground(Color.ORANGE);
                }
                else if(matrix[i-2][j+1].getType()!='s' && !matrix[i-2][j+1].isWhite()){
                    matrix[i-2][j+1].getButton().setBackground(Color.ORANGE);
                }
            }

            if(i>1 && j>0){
                if(matrix[i-2][j-1].getType()=='s'){
                    matrix[i-2][j-1].getButton().setBackground(Color.ORANGE);
                }
                else if(matrix[i-2][j-1].getType()!='s' && !matrix[i-2][j-1].isWhite()){
                    matrix[i-2][j-1].getButton().setBackground(Color.ORANGE);
                }
            }

            if(i>0 && j<6){
                if(matrix[i-1][j+2].getType()=='s'){
                    matrix[i-1][j+2].getButton().setBackground(Color.ORANGE);
                }
                else if(matrix[i-1][j+2].getType()!='s' && !matrix[i-1][j+2].isWhite()){
                    matrix[i-1][j+2].getButton().setBackground(Color.ORANGE);
                }
            }

            if(i<7 && j<6){
                if(matrix[i+1][j+2].getType()=='s'){
                    matrix[i+1][j+2].getButton().setBackground(Color.ORANGE);
                }
                else if(matrix[i+1][j+2].getType()!='s' && !matrix[i+1][j+2].isWhite()){
                    matrix[i+1][j+2].getButton().setBackground(Color.ORANGE);
                }
            }

            if(i<6 && j<7){     //basso destra
                if(matrix[i+2][j+1].getType()=='s'){
                    matrix[i+2][j+1].getButton().setBackground(Color.ORANGE);
                }
                else if(matrix[i+2][j+1].getType()!='s' && !matrix[i+2][j+1].isWhite()){
                    matrix[i+2][j+1].getButton().setBackground(Color.ORANGE);
                }
            }

            if(i<6 && j>0){
                if(matrix[i+2][j-1].getType()=='s'){
                    matrix[i+2][j-1].getButton().setBackground(Color.ORANGE);
                }
                else if(matrix[i+2][j-1].getType()!='s' && !matrix[i+2][j-1].isWhite()){
                    matrix[i+2][j-1].getButton().setBackground(Color.ORANGE);
                }
            }

            if(i>0 && j>1){
                if(matrix[i-1][j-2].getType()=='s'){
                    matrix[i-1][j-2].getButton().setBackground(Color.ORANGE);
                }
                else if(matrix[i-1][j-2].getType()!='s' && !matrix[i-1][j-2].isWhite()){
                    matrix[i-1][j-2].getButton().setBackground(Color.ORANGE);
                }
            }

            if(i<7 && j>1){
                if(matrix[i+1][j-2].getType()=='s'){
                    matrix[i+1][j-2].getButton().setBackground(Color.ORANGE);
                }
                else if(matrix[i+1][j-2].getType()!='s' && !matrix[i+1][j-2].isWhite()){
                    matrix[i+1][j-2].getButton().setBackground(Color.ORANGE);
                }
            }
        }
        else if(!matrix[i][j].isWhite() && !turno){
            matrix[i][j].getButton().setBackground(Color.PINK);
            if(i>1 && j<7){
                if(matrix[i-2][j+1].getType()=='s'){
                    matrix[i-2][j+1].getButton().setBackground(Color.ORANGE);
                }
                else if(matrix[i-2][j+1].getType()!='s' && matrix[i-2][j+1].isWhite()){
                    matrix[i-2][j+1].getButton().setBackground(Color.ORANGE);
                }
            }

            if(i>1 && j>0){
                if(matrix[i-2][j-1].getType()=='s'){
                    matrix[i-2][j-1].getButton().setBackground(Color.ORANGE);
                }
                else if(matrix[i-2][j-1].getType()!='s' && matrix[i-2][j-1].isWhite()){
                    matrix[i-2][j-1].getButton().setBackground(Color.ORANGE);
                }
            }

            if(i>0 && j<6){
                if(matrix[i-1][j+2].getType()=='s'){
                    matrix[i-1][j+2].getButton().setBackground(Color.ORANGE);
                }
                else if(matrix[i-1][j+2].getType()!='s' && matrix[i-1][j+2].isWhite()){
                    matrix[i-1][j+2].getButton().setBackground(Color.ORANGE);
                }
            }

            if(i<7 && j<6){
                if(matrix[i+1][j+2].getType()=='s'){
                    matrix[i+1][j+2].getButton().setBackground(Color.ORANGE);
                }
                else if(matrix[i+1][j+2].getType()!='s' && matrix[i+1][j+2].isWhite()){
                    matrix[i+1][j+2].getButton().setBackground(Color.ORANGE);
                }
            }

            if(i<6 && j<7){
                if(matrix[i+2][j+1].getType()=='s'){
                    matrix[i+2][j+1].getButton().setBackground(Color.ORANGE);
                }
                else if(matrix[i+2][j+1].getType()!='s' && matrix[i+2][j+1].isWhite()){
                    matrix[i+2][j+1].getButton().setBackground(Color.ORANGE);
                }
            }

            if(i<6 && j>0){
                if(matrix[i+2][j-1].getType()=='s'){
                    matrix[i+2][j-1].getButton().setBackground(Color.ORANGE);
                }
                else if(matrix[i+2][j-1].getType()!='s' && matrix[i+2][j-1].isWhite()){
                    matrix[i+2][j-1].getButton().setBackground(Color.ORANGE);
                }
            }

            if(i>0 && j>1){
                if(matrix[i-1][j-2].getType()=='s'){
                    matrix[i-1][j-2].getButton().setBackground(Color.ORANGE);
                }
                else if(matrix[i-1][j-2].getType()!='s' && matrix[i-1][j-2].isWhite()){
                    matrix[i-1][j-2].getButton().setBackground(Color.ORANGE);
                }
            }

            if(i<7 && j>1){
                if(matrix[i+1][j-2].getType()=='s'){
                    matrix[i+1][j-2].getButton().setBackground(Color.ORANGE);
                }
                else if(matrix[i+1][j-2].getType()!='s' && matrix[i+1][j-2].isWhite()){
                    matrix[i+1][j-2].getButton().setBackground(Color.ORANGE);
                }
            }
        }
    }


    public void movementB(Piece[][] matrix,int i, int j,boolean turno){
        int cnt1,cnt2;
        boolean brk=true;


        if(matrix[i][j].isWhite() && turno) {
            matrix[i][j].getButton().setBackground(Color.PINK);
            cnt1 = i+1;
            cnt2 = j+1;
            while (cnt1 < 8 && cnt2 < 8 && brk) {
                if (matrix[cnt1][cnt2].getType()!='s') {
                    if(matrix[cnt1][cnt2].isWhite()) {
                        brk=false;
                    }
                    else {
                        matrix[cnt1][cnt2].getButton().setBackground(Color.ORANGE);
                        brk=false;
                    }
                }
                else if(matrix[cnt1][cnt2].getType()=='s') {
                    matrix[cnt1][cnt2].getButton().setBackground(Color.ORANGE);
                }
                cnt1++;
                cnt2++;
            }

            brk=true;
            cnt1= i+1;
            cnt2= j-1;
            while (cnt1 < 8 && cnt2 >= 0 && brk) {
                if (matrix[cnt1][cnt2].getType()!='s') {
                    if(matrix[cnt1][cnt2].isWhite()) {
                        brk=false;
                    }
                    else {
                        matrix[cnt1][cnt2].getButton().setBackground(Color.ORANGE);
                        brk=false;
                    }
                }
                else if(matrix[cnt1][cnt2].getType()=='s') {
                    matrix[cnt1][cnt2].getButton().setBackground(Color.ORANGE);
                }
                cnt1++;
                cnt2--;
            }

            brk=true;
            cnt1= i-1;
            cnt2= j+1;
            while (cnt1 >= 0 && cnt2 < 8 && brk) {
                if (matrix[cnt1][cnt2].getType()!='s') {
                    if(matrix[cnt1][cnt2].isWhite()) {
                        brk=false;
                    }
                    else {
                        matrix[cnt1][cnt2].getButton().setBackground(Color.ORANGE);
                        brk=false;
                    }
                }
                else if(matrix[cnt1][cnt2].getType()=='s') {
                    matrix[cnt1][cnt2].getButton().setBackground(Color.ORANGE);
                }
                cnt1--;
                cnt2++;
            }

            brk=true;
            cnt1= i-1;
            cnt2= j-1;
            while (cnt1 >= 0 && cnt2 >= 0 && brk) {
                if (matrix[cnt1][cnt2].getType()!='s') {
                    if(matrix[cnt1][cnt2].isWhite()) {
                        brk=false;
                    }
                    else {
                        matrix[cnt1][cnt2].getButton().setBackground(Color.ORANGE);
                        brk=false;
                    }
                }
                else if(matrix[cnt1][cnt2].getType()=='s') {
                    matrix[cnt1][cnt2].getButton().setBackground(Color.ORANGE);
                }
                cnt1--;
                cnt2--;
            }
        }
        else if(!matrix[i][j].isWhite() && !turno){
            matrix[i][j].getButton().setBackground(Color.PINK);
            cnt1 = i+1;
            cnt2 = j+1;
            while (cnt1 < 8 && cnt2 < 8 && brk) {
                if (matrix[cnt1][cnt2].getType()!='s') {
                    if(!matrix[cnt1][cnt2].isWhite()) {
                        brk=false;
                    }
                    else {
                        matrix[cnt1][cnt2].getButton().setBackground(Color.ORANGE);
                        brk=false;
                    }
                }
                else if(matrix[cnt1][cnt2].getType()=='s') {
                    matrix[cnt1][cnt2].getButton().setBackground(Color.ORANGE);
                }
                cnt1++;
                cnt2++;
            }

            brk=true;
            cnt1= i+1;
            cnt2= j-1;
            while (cnt1 < 8 && cnt2 >= 0 && brk) {
                if (matrix[cnt1][cnt2].getType()!='s') {
                    if(!matrix[cnt1][cnt2].isWhite()) {
                        brk=false;
                    }
                    else {
                        matrix[cnt1][cnt2].getButton().setBackground(Color.ORANGE);
                        brk=false;
                    }
                }
                else if(matrix[cnt1][cnt2].getType()=='s') {
                    matrix[cnt1][cnt2].getButton().setBackground(Color.ORANGE);
                }
                cnt1++;
                cnt2--;
            }

            brk=true;
            cnt1= i-1;
            cnt2= j+1;
            while (cnt1 >= 0 && cnt2 < 8 && brk) {
                if (matrix[cnt1][cnt2].getType()!='s') {
                    if(!matrix[cnt1][cnt2].isWhite()) {
                        brk=false;
                    }
                    else {
                        matrix[cnt1][cnt2].getButton().setBackground(Color.ORANGE);
                        brk=false;
                    }
                }
                else if(matrix[cnt1][cnt2].getType()=='s') {
                    matrix[cnt1][cnt2].getButton().setBackground(Color.ORANGE);
                }
                cnt1--;
                cnt2++;
            }

            brk=true;
            cnt1= i-1;
            cnt2= j-1;
            while (cnt1 >= 0 && cnt2 >= 0 && brk) {
                if (matrix[cnt1][cnt2].getType()!='s') {
                    if(!matrix[cnt1][cnt2].isWhite()) {
                        brk=false;
                    }
                    else {
                        matrix[cnt1][cnt2].getButton().setBackground(Color.ORANGE);
                        brk=false;
                    }
                }
                else if(matrix[cnt1][cnt2].getType()=='s') {
                    matrix[cnt1][cnt2].getButton().setBackground(Color.ORANGE);
                }
                cnt1--;
                cnt2--;
            }
        }
    }


    public void movementQ(Piece[][] matrix,int i, int j,boolean turno){
        int cnt1,cnt2;
        boolean brk=true;


        if(matrix[i][j].isWhite() && turno) {
            matrix[i][j].getButton().setBackground(Color.PINK);
            cnt1 = i+1;
            while (cnt1 < 8 && brk) {
                if (matrix[cnt1][j].getType()!='s') {
                    if(matrix[cnt1][j].isWhite()) {
                        brk=false;
                    }
                    else {
                        matrix[cnt1][j].getButton().setBackground(Color.ORANGE);
                        brk=false;
                    }
                }
                else if(matrix[cnt1][j].getType()=='s') {
                    matrix[cnt1][j].getButton().setBackground(Color.ORANGE);
                }
                cnt1++;
            }

            brk=true;
            cnt1 = i-1;
            while (cnt1 >= 0 && brk) {
                if (matrix[cnt1][j].getType()!='s') {
                    if(matrix[cnt1][j].isWhite()) {
                        brk=false;
                    }
                    else {
                        matrix[cnt1][j].getButton().setBackground(Color.ORANGE);
                        brk=false;
                    }
                }
                else if(matrix[cnt1][j].getType()=='s') {
                    matrix[cnt1][j].getButton().setBackground(Color.ORANGE);
                }
                cnt1--;
            }

            brk=true;
            cnt1 = j+1;
            while (cnt1 < 8 && brk) {
                if (matrix[i][cnt1].getType()!='s') {
                    if(matrix[i][cnt1].isWhite()) {
                        brk=false;
                    }
                    else {
                        matrix[i][cnt1].getButton().setBackground(Color.ORANGE);
                        brk=false;
                    }
                }
                else if(matrix[i][cnt1].getType()=='s') {
                    matrix[i][cnt1].getButton().setBackground(Color.ORANGE);
                }
                cnt1++;
            }

            brk=true;
            cnt1 = j-1;
            while (cnt1 >= 0 && brk) {
                if (matrix[i][cnt1].getType()!='s') {
                    if(matrix[i][cnt1].isWhite()) {
                        brk=false;
                    }
                    else {
                        matrix[i][cnt1].getButton().setBackground(Color.ORANGE);
                        brk=false;
                    }
                }
                else if(matrix[i][cnt1].getType()=='s') {
                    matrix[i][cnt1].getButton().setBackground(Color.ORANGE);
                }
                cnt1--;
            }

            brk=true;
            cnt1 = i+1;
            cnt2 = j+1;
            while (cnt1 < 8 && cnt2 < 8 && brk) {
                if (matrix[cnt1][cnt2].getType()!='s') {
                    if(matrix[cnt1][cnt2].isWhite()) {
                        brk=false;
                    }
                    else {
                        matrix[cnt1][cnt2].getButton().setBackground(Color.ORANGE);
                        brk=false;
                    }
                }
                else if(matrix[cnt1][cnt2].getType()=='s') {
                    matrix[cnt1][cnt2].getButton().setBackground(Color.ORANGE);
                }
                cnt1++;
                cnt2++;
            }

            brk=true;
            cnt1= i+1;
            cnt2= j-1;
            while (cnt1 < 8 && cnt2 >= 0 && brk) {
                if (matrix[cnt1][cnt2].getType()!='s') {
                    if(matrix[cnt1][cnt2].isWhite()) {
                        brk=false;
                    }
                    else {
                        matrix[cnt1][cnt2].getButton().setBackground(Color.ORANGE);
                        brk=false;
                    }
                }
                else if(matrix[cnt1][cnt2].getType()=='s') {
                    matrix[cnt1][cnt2].getButton().setBackground(Color.ORANGE);
                }
                cnt1++;
                cnt2--;
            }

            brk=true;
            cnt1= i-1;
            cnt2= j+1;
            while (cnt1 >= 0 && cnt2 < 8 && brk) {
                if (matrix[cnt1][cnt2].getType()!='s') {
                    if(matrix[cnt1][cnt2].isWhite()) {
                        brk=false;
                    }
                    else {
                        matrix[cnt1][cnt2].getButton().setBackground(Color.ORANGE);
                        brk=false;
                    }
                }
                else if(matrix[cnt1][cnt2].getType()=='s') {
                    matrix[cnt1][cnt2].getButton().setBackground(Color.ORANGE);
                }
                cnt1--;
                cnt2++;
            }

            brk=true;
            cnt1= i-1;
            cnt2= j-1;
            while (cnt1 >= 0 && cnt2 >= 0 && brk) {
                if (matrix[cnt1][cnt2].getType()!='s') {
                    if(matrix[cnt1][cnt2].isWhite()) {
                        brk=false;
                    }
                    else {
                        matrix[cnt1][cnt2].getButton().setBackground(Color.ORANGE);
                        brk=false;
                    }
                }
                else if(matrix[cnt1][cnt2].getType()=='s') {
                    matrix[cnt1][cnt2].getButton().setBackground(Color.ORANGE);
                }
                cnt1--;
                cnt2--;
            }
        }
        else if(!matrix[i][j].isWhite() && !turno ){
            matrix[i][j].getButton().setBackground(Color.PINK);
            cnt1 = i+1;
            while (cnt1 < 8 && brk) {
                if (matrix[cnt1][j].getType()!='s') {
                    if(!matrix[cnt1][j].isWhite()) {
                        brk=false;
                    }
                    else {
                        matrix[cnt1][j].getButton().setBackground(Color.ORANGE);
                        brk=false;
                    }
                }
                else if(matrix[cnt1][j].getType()=='s') {
                    matrix[cnt1][j].getButton().setBackground(Color.ORANGE);
                }
                cnt1++;
            }

            brk=true;
            cnt1 = i-1;
            while (cnt1 >= 0 && brk) {
                if (matrix[cnt1][j].getType()!='s') {
                    if(!matrix[cnt1][j].isWhite()) {
                        brk=false;
                    }
                    else {
                        matrix[cnt1][j].getButton().setBackground(Color.ORANGE);
                        brk=false;

                    }

                }
                else if(matrix[cnt1][j].getType()=='s') {
                    matrix[cnt1][j].getButton().setBackground(Color.ORANGE);
                }
                cnt1--;
            }

            brk=true;
            cnt1 = j+1;
            while (cnt1 < 8 && brk) {
                if (matrix[i][cnt1].getType()!='s') {
                    if(!matrix[i][cnt1].isWhite()) {
                        brk=false;
                    }
                    else {
                        matrix[i][cnt1].getButton().setBackground(Color.ORANGE);
                        brk=false;
                    }
                }
                else if(matrix[i][cnt1].getType()=='s') {
                    matrix[i][cnt1].getButton().setBackground(Color.ORANGE);
                }
                cnt1++;
            }

            brk=true;
            cnt1 = j-1;
            while (cnt1 >= 0 && brk) {
                if (matrix[i][cnt1].getType()!='s') {
                    if(!matrix[i][cnt1].isWhite()) {
                        brk=false;
                    }
                    else {
                        matrix[i][cnt1].getButton().setBackground(Color.ORANGE);
                        brk=false;

                    }

                }
                else if(matrix[i][cnt1].getType()=='s') {
                    matrix[i][cnt1].getButton().setBackground(Color.ORANGE);
                }
                cnt1--;
            }

            brk=true;
            cnt1 = i+1;
            cnt2 = j+1;
            while (cnt1 < 8 && cnt2 < 8 && brk) {
                if (matrix[cnt1][cnt2].getType()!='s') {
                    if(!matrix[cnt1][cnt2].isWhite()) {
                        brk=false;
                    }
                    else {
                        matrix[cnt1][cnt2].getButton().setBackground(Color.ORANGE);
                        brk=false;
                    }
                }
                else if(matrix[cnt1][cnt2].getType()=='s') {
                    matrix[cnt1][cnt2].getButton().setBackground(Color.ORANGE);
                }
                cnt1++;
                cnt2++;
            }

            brk=true;
            cnt1= i+1;
            cnt2= j-1;
            while (cnt1 < 8 && cnt2 >= 0 && brk) {
                if (matrix[cnt1][cnt2].getType()!='s') {
                    if(!matrix[cnt1][cnt2].isWhite()) {
                        brk=false;
                    }
                    else {
                        matrix[cnt1][cnt2].getButton().setBackground(Color.ORANGE);
                        brk=false;
                    }
                }
                else if(matrix[cnt1][cnt2].getType()=='s') {
                    matrix[cnt1][cnt2].getButton().setBackground(Color.ORANGE);
                }
                cnt1++;
                cnt2--;
            }

            brk=true;
            cnt1= i-1;
            cnt2= j+1;
            while (cnt1 >= 0 && cnt2 < 8 && brk) {
                if (matrix[cnt1][cnt2].getType()!='s') {
                    if(!matrix[cnt1][cnt2].isWhite()) {
                        brk=false;
                    }
                    else {
                        matrix[cnt1][cnt2].getButton().setBackground(Color.ORANGE);
                        brk=false;
                    }
                }
                else if(matrix[cnt1][cnt2].getType()=='s') {
                    matrix[cnt1][cnt2].getButton().setBackground(Color.ORANGE);
                }
                cnt1--;
                cnt2++;
            }

            brk=true;
            cnt1= i-1;
            cnt2= j-1;
            while (cnt1 >= 0 && cnt2 >= 0 && brk) {
                if (matrix[cnt1][cnt2].getType()!='s') {
                    if(!matrix[cnt1][cnt2].isWhite()) {
                        brk=false;
                    }
                    else {
                        matrix[cnt1][cnt2].getButton().setBackground(Color.ORANGE);
                        brk=false;
                    }
                }
                else if(matrix[cnt1][cnt2].getType()=='s') {
                    matrix[cnt1][cnt2].getButton().setBackground(Color.ORANGE);
                }
                cnt1--;
                cnt2--;
            }
        }
    }


    public void movementK(Piece[][] matrix,int i, int j,boolean turno){


        if(matrix[i][j].isWhite() && turno) {
            matrix[i][j].getButton().setBackground(Color.PINK);

            if(i>0){
                if(matrix[i-1][j].getType()=='s'){
                    matrix[i-1][j].getButton().setBackground(Color.ORANGE);
                }
                else if(matrix[i-1][j].getType()!='s' && !matrix[i-1][j].isWhite()){
                    matrix[i-1][j].getButton().setBackground(Color.ORANGE);
                }
            }

            if(i<7){
                if(matrix[i+1][j].getType()=='s'){
                    matrix[i+1][j].getButton().setBackground(Color.ORANGE);
                }
                else if(matrix[i+1][j].getType()!='s' && !matrix[i+1][j].isWhite()){
                    matrix[i+1][j].getButton().setBackground(Color.ORANGE);
                }
            }

            if(j>0){
                if(matrix[i][j-1].getType()=='s'){
                    matrix[i][j-1].getButton().setBackground(Color.ORANGE);
                }
                else if(matrix[i][j-1].getType()!='s' && !matrix[i][j-1].isWhite()){
                    matrix[i][j-1].getButton().setBackground(Color.ORANGE);
                }
            }

            if(j<7){
                if(matrix[i][j+1].getType()=='s'){
                    matrix[i][j+1].getButton().setBackground(Color.ORANGE);
                }
                else if(matrix[i][j+1].getType()!='s' && !matrix[i][j+1].isWhite()){
                    matrix[i][j+1].getButton().setBackground(Color.ORANGE);
                }
            }

            if(i>0 && j>0){
                if(matrix[i-1][j-1].getType()=='s'){
                    matrix[i-1][j-1].getButton().setBackground(Color.ORANGE);
                }
                else if(matrix[i-1][j-1].getType()!='s' && !matrix[i-1][j-1].isWhite()){
                    matrix[i-1][j-1].getButton().setBackground(Color.ORANGE);
                }
            }

            if(i>0 && j<7){
                if(matrix[i-1][j+1].getType()=='s'){
                    matrix[i-1][j+1].getButton().setBackground(Color.ORANGE);
                }
                else if(matrix[i-1][j+1].getType()!='s' && !matrix[i-1][j+1].isWhite()){
                    matrix[i-1][j+1].getButton().setBackground(Color.ORANGE);
                }
            }

            if(i<7 && j>0){
                if(matrix[i+1][j-1].getType()=='s'){
                    matrix[i+1][j-1].getButton().setBackground(Color.ORANGE);
                }
                else if(matrix[i+1][j-1].getType()!='s' && !matrix[i+1][j-1].isWhite()){
                    matrix[i+1][j-1].getButton().setBackground(Color.ORANGE);
                }
            }

            if(i<7 && j<7){
                if(matrix[i+1][j+1].getType()=='s'){
                    matrix[i+1][j+1].getButton().setBackground(Color.ORANGE);
                }
                else if(matrix[i+1][j+1].getType()!='s' && !matrix[i+1][j+1].isWhite()){
                    matrix[i+1][j+1].getButton().setBackground(Color.ORANGE);
                }
            }
        }
        else if(!matrix[i][j].isWhite() && !turno){
            matrix[i][j].getButton().setBackground(Color.PINK);

            if(i>0){
                if(matrix[i-1][j].getType()=='s'){
                    matrix[i-1][j].getButton().setBackground(Color.ORANGE);
                }
                else if(matrix[i-1][j].getType()!='s' && matrix[i-1][j].isWhite()){
                    matrix[i-1][j].getButton().setBackground(Color.ORANGE);
                }
            }

            if(i<7){
                if(matrix[i+1][j].getType()=='s'){
                    matrix[i+1][j].getButton().setBackground(Color.ORANGE);
                }
                else if(matrix[i+1][j].getType()!='s' && matrix[i+1][j].isWhite()){
                    matrix[i+1][j].getButton().setBackground(Color.ORANGE);
                }
            }

            if(j>0){
                if(matrix[i][j-1].getType()=='s'){
                    matrix[i][j-1].getButton().setBackground(Color.ORANGE);
                }
                else if(matrix[i][j-1].getType()!='s' && matrix[i][j-1].isWhite()){
                    matrix[i][j-1].getButton().setBackground(Color.ORANGE);
                }
            }

            if(j<7){
                if(matrix[i][j+1].getType()=='s'){
                    matrix[i][j+1].getButton().setBackground(Color.ORANGE);
                }
                else if(matrix[i][j+1].getType()!='s' && matrix[i][j+1].isWhite()){
                    matrix[i][j+1].getButton().setBackground(Color.ORANGE);
                }
            }

            if(i>0 && j>0){
                if(matrix[i-1][j-1].getType()=='s'){
                    matrix[i-1][j-1].getButton().setBackground(Color.ORANGE);
                }
                else if(matrix[i-1][j-1].getType()!='s' && matrix[i-1][j-1].isWhite()){
                    matrix[i-1][j-1].getButton().setBackground(Color.ORANGE);
                }
            }

            if(i>0 && j<7){
                if(matrix[i-1][j+1].getType()=='s'){
                    matrix[i-1][j+1].getButton().setBackground(Color.ORANGE);
                }
                else if(matrix[i-1][j+1].getType()!='s' && matrix[i-1][j+1].isWhite()){
                    matrix[i-1][j+1].getButton().setBackground(Color.ORANGE);
                }
            }

            if(i<7 && j>0){
                if(matrix[i+1][j-1].getType()=='s'){
                    matrix[i+1][j-1].getButton().setBackground(Color.ORANGE);
                }
                else if(matrix[i+1][j-1].getType()!='s' && matrix[i+1][j-1].isWhite()){
                    matrix[i+1][j-1].getButton().setBackground(Color.ORANGE);
                }
            }

            if(i<7 && j<7){
                if(matrix[i+1][j+1].getType()=='s'){
                    matrix[i+1][j+1].getButton().setBackground(Color.ORANGE);
                }
                else if(matrix[i+1][j+1].getType()!='s' && matrix[i+1][j+1].isWhite()){
                    matrix[i+1][j+1].getButton().setBackground(Color.ORANGE);
                }
            }
        }
    }


    public void setImage(){
        switch(type){
            case 's':
                button.setIcon(null);
                break;
            case 'p':
                if(white){
                    try {
                        Image img = ImageIO.read(getClass().getResource("Images/Wpawn.png"));
                        button.setIcon(new ImageIcon(img));
                    } catch (Exception ex) {
                        System.out.println(ex);
                    }
                }
                else{
                    try {
                        Image img = ImageIO.read(getClass().getResource("Images/Bpawn.png"));
                        button.setIcon(new ImageIcon(img));
                    } catch (Exception ex) {
                        System.out.println(ex);
                    }
                }
                break;
            case 'r':
                if(white){
                    try {
                        Image img = ImageIO.read(getClass().getResource("Images/Wrook.png"));
                        button.setIcon(new ImageIcon(img));
                    } catch (Exception ex) {
                        System.out.println(ex);
                    }
                }
                else{
                    try {
                        Image img = ImageIO.read(getClass().getResource("Images/Brook.png"));
                        button.setIcon(new ImageIcon(img));
                    } catch (Exception ex) {
                        System.out.println(ex);
                    }
                }
                break;
            case 'h':
                if(white){
                    try {
                        Image img = ImageIO.read(getClass().getResource("Images/Whorse.png"));
                        button.setIcon(new ImageIcon(img));
                    } catch (Exception ex) {
                        System.out.println(ex);
                    };
                }
                else{
                    try {
                        Image img = ImageIO.read(getClass().getResource("Images/Bhorse.png"));
                        button.setIcon(new ImageIcon(img));
                    } catch (Exception ex) {
                        System.out.println(ex);
                    }
                }
                break;
            case 'b':
                if(white){
                    try {
                        Image img = ImageIO.read(getClass().getResource("Images/Wbishop.png"));
                        button.setIcon(new ImageIcon(img));
                    } catch (Exception ex) {
                        System.out.println(ex);
                    }
                }
                else{
                    try {
                        Image img = ImageIO.read(getClass().getResource("Images/Bbishop.png"));
                        button.setIcon(new ImageIcon(img));
                    } catch (Exception ex) {
                        System.out.println(ex);
                    }
                }
                break;
            case 'q':
                if(white){
                    try {
                        Image img = ImageIO.read(getClass().getResource("Images/Wqueen.png"));
                        button.setIcon(new ImageIcon(img));
                    } catch (Exception ex) {
                        System.out.println(ex);
                    }
                }
                else{
                    try {
                        Image img = ImageIO.read(getClass().getResource("Images/Bqueen.png"));
                        button.setIcon(new ImageIcon(img));
                    } catch (Exception ex) {
                        System.out.println(ex);
                    }
                }
                break;
            case 'k':
                if(white){
                    try {
                        Image img = ImageIO.read(getClass().getResource("Images/Wking.png"));
                        button.setIcon(new ImageIcon(img));
                    } catch (Exception ex) {
                        System.out.println(ex);
                    }
                }
                else{
                    try {
                        Image img = ImageIO.read(getClass().getResource("Images/Bking.png"));
                        button.setIcon(new ImageIcon(img));
                    } catch (Exception ex) {
                        System.out.println(ex);
                    }
                }
                break;
        }
    }
}