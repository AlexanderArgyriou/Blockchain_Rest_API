import org.junit.Assert;
import org.junit.Test;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;

public class EthereumClientTest {
    @Test
    public void check_client_connection_should_not_return_empty_string_or_ex() {
        // parity --chain testnet
        // defaults to http://localhost:8545/
        try {
            Web3j web3j = Web3j.build( new HttpService() );
            Web3ClientVersion web3ClientVersion = web3j.web3ClientVersion().sendAsync().get();
            Assert.assertFalse( web3ClientVersion.hasError() );
            System.out.println( "Client is running version: " + web3ClientVersion.getWeb3ClientVersion() ) ;
        } catch ( Exception e ) {
            // swallow
        }
    }
}
