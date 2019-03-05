
package co.manager.b1ws.state;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the co.manager.b1ws.client.state package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: co.manager.b1ws.client.state
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link StatesParams }
     * 
     */
    public StatesParams createStatesParams() {
        return new StatesParams();
    }

    /**
     * Create an instance of {@link DeleteState }
     * 
     */
    public DeleteState createDeleteState() {
        return new DeleteState();
    }

    /**
     * Create an instance of {@link co.manager.b1ws.state.StateParams }
     * 
     */
    public co.manager.b1ws.state.StateParams createStateParams() {
        return new co.manager.b1ws.state.StateParams();
    }

    /**
     * Create an instance of {@link AddState }
     * 
     */
    public AddState createAddState() {
        return new AddState();
    }

    /**
     * Create an instance of {@link State }
     * 
     */
    public State createState() {
        return new State();
    }

    /**
     * Create an instance of {@link GetState }
     * 
     */
    public GetState createGetState() {
        return new GetState();
    }

    /**
     * Create an instance of {@link GetStateList }
     * 
     */
    public GetStateList createGetStateList() {
        return new GetStateList();
    }

    /**
     * Create an instance of {@link UpdateState }
     * 
     */
    public UpdateState createUpdateState() {
        return new UpdateState();
    }

    /**
     * Create an instance of {@link GetStateResponse }
     * 
     */
    public GetStateResponse createGetStateResponse() {
        return new GetStateResponse();
    }

    /**
     * Create an instance of {@link UpdateStateResponse }
     * 
     */
    public UpdateStateResponse createUpdateStateResponse() {
        return new UpdateStateResponse();
    }

    /**
     * Create an instance of {@link MsgHeader }
     * 
     */
    public MsgHeader createMsgHeader() {
        return new MsgHeader();
    }

    /**
     * Create an instance of {@link AddStateResponse }
     * 
     */
    public AddStateResponse createAddStateResponse() {
        return new AddStateResponse();
    }

    /**
     * Create an instance of {@link DeleteStateResponse }
     * 
     */
    public DeleteStateResponse createDeleteStateResponse() {
        return new DeleteStateResponse();
    }

    /**
     * Create an instance of {@link StatesParams.StateParams }
     * 
     */
    public StatesParams.StateParams createStatesParamsStateParams() {
        return new StatesParams.StateParams();
    }

    /**
     * Create an instance of {@link GetStateListResponse }
     * 
     */
    public GetStateListResponse createGetStateListResponse() {
        return new GetStateListResponse();
    }

}
