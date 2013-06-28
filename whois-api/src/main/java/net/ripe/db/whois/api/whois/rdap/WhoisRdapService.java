package net.ripe.db.whois.api.whois.rdap;

import net.ripe.db.whois.api.whois.StreamingMarshal;
import net.ripe.db.whois.api.whois.WhoisService;
import net.ripe.db.whois.api.whois.domain.Parameters;
import net.ripe.db.whois.api.whois.domain.WhoisResources;
import net.ripe.db.whois.api.whois.rdap.RdapStreamingMarshalJson;
import net.ripe.db.whois.api.whois.rdap.RdapStreamingOutput;
import net.ripe.db.whois.common.DateTimeProvider;
import net.ripe.db.whois.common.dao.RpslObjectDao;
import net.ripe.db.whois.common.dao.RpslObjectUpdateDao;
import net.ripe.db.whois.common.source.SourceContext;
import net.ripe.db.whois.query.handler.QueryHandler;
import net.ripe.db.whois.query.query.Query;
import net.ripe.db.whois.update.handler.UpdateRequestHandler;
import net.ripe.db.whois.update.log.LoggerContext;
import org.codehaus.enunciate.jaxrs.TypeHint;
import org.codehaus.enunciate.modules.jersey.ExternallyManagedLifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Nullable;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.InetAddress;

@ExternallyManagedLifecycle
@Component
@Path("/")
public class WhoisRdapService extends WhoisService {

    @Autowired
    public WhoisRdapService(final DateTimeProvider dateTimeProvider, final UpdateRequestHandler updateRequestHandler, final LoggerContext loggerContext, final RpslObjectDao rpslObjectDao, final RpslObjectUpdateDao rpslObjectUpdateDao, final SourceContext sourceContext, final QueryHandler queryHandler) {
        super(dateTimeProvider, updateRequestHandler,loggerContext, rpslObjectDao, rpslObjectUpdateDao, sourceContext, queryHandler);
    }

    @GET
    @TypeHint(WhoisResources.class)
    @Produces({MediaType.APPLICATION_JSON})//,MediaType.APPLICATION_JSON})
    @Path("/{objectType}/{key:.*}")
    public Response lookup(
            @Context final HttpServletRequest request,
            @PathParam("objectType") final String objectType,
            @PathParam("key") final String key) {
        
        /* RDAP object types do not map directly to whois object
         * types, so translate accordingly here for the remaining
         * object types as they are implemented. */

        String whoisObjectType =
            objectType.equals("autnum") ? "aut-num"
                                        : objectType;
                            
        return lookupObject(request, 
                            this.sourceContext
                                .getWhoisSlaveSource().getName().toString(), 
                            whoisObjectType, 
                            key, 
                            false);
    }

    protected Response handleQueryAndStreamResponse(final Query query, final HttpServletRequest request, final InetAddress remoteAddress, final int contextId, @Nullable final Parameters parameters) {
        final StreamingMarshal streamingMarshal = new RdapStreamingMarshalJson();

        RdapStreamingOutput rso = new RdapStreamingOutput(streamingMarshal,queryHandler,parameters,query,remoteAddress,contextId);

        return Response.ok(rso).build();
    }
}
