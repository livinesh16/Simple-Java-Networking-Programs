public class CRC {
    public static void main(String args[]){
        String DataWords[] = new String[]{"10011","110011"};
        String generator = "1111";
        for(String word : DataWords){
            System.out.println("Data Word : " + word);
            String withCrc = computeCRC(word,generator);
            System.out.println("Data Sent(With CRC): " + withCrc);

            if(verifyCRC(withCrc,generator)){
                System.out.println("No Errors");
            }else{
                System.out.println("Error Detected");
            }
        }
    }
    static String computeCRC(String data,String divisor){
        int len = divisor.length();
        int datalen = data.length();
        String paddeddata = data + "0".repeat(len-1);
        char[] dividend = paddeddata.toCharArray();
        for(int i = 0;i<datalen;i++){
            if(dividend[i]=='1'){
                for(int j = 0;j<len;j++){
                    dividend[i+j] = (dividend[i+j]==divisor.charAt(j))?'0':'1';
                }
            }
        }

        String rem = new String(dividend);
        return data + rem.substring(datalen);
    }
    static boolean verifyCRC(String received,String divisor){
        int len = divisor.length();
        char[] dividend = received.toCharArray();
        for(int i = 0;i<dividend.length-(len-1);i++){
            if(dividend[i]=='1'){
                for(int j = 0;j<len;j++){
                    dividend[i+j] = (dividend[i+j]==divisor.charAt(j))?'0':'1';
                }
            }
        }
        for(int i = dividend.length-(len-1);i<dividend.length;i++){
            if(dividend[i]=='1')
                return false;
        }
        return true;
    }
}
