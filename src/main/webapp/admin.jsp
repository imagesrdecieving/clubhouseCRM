<%@ include file="/taglibs.jsp" %>
<t:page title="clubhouseCRM Admin">

<jsp:attribute name="page_meta_tags">
<script type="text/javascript" src="/js/restful.js"></script>
<script type="text/javascript">
$(function() {
    var restMethod = {
            href: "/crm/member",
            type: "GET"
        };
    restful.callMethod(restMethod, null, displayMembers);

    function displayMembers(msg) {
        $.each(msg.entities, function() {
            var tr = $('<tr>');
            $.each(this, function() {
                tr.append('<td>').append(this);
            });
            $('#members').append(tr);
        });
    }
});
</script>
</jsp:attribute>

<jsp:attribute name="sidebar_content">
<div class="sidebar_header">Operations</div>
<input type="button" class="sidebar_button" id="add_member" value="Add Member" />
<input type="button" class="sidebar_button" id="remove_member" value="Remove Member" />
</jsp:attribute>

<jsp:body>
<div style="margin-left: 15px">
    Hello From Admin ${name}
    <table id="members">
    </table>
</div>
</jsp:body>
</t:page>