<#import "macro/common.ftl" as c>

<@c.page>
User editor

<form action="/user" method="post">
    <input type="text" name="username" value="${user.username}">
    <#list roles as role>
    <div>
        <label><input type="checkbox" name="${role}" ${user.roles?seq_contains(role)?string("checked", "")}>${role}</label>
    </div>
    </#list>
    <#--<#list orderStatus as order>
    <div>
        <label><input type="checkbox" name="${order}" ${user.orderStatus?seq_contains(order)?string("checked", "")}>${order}</label>
    </div>
    </#list>-->
    <input type="hidden" value="${user.id}" name="userId">
    <input type="hidden" value="${_csrf.token}" name="_csrf">
    <button type="submit">Save</button>
</form>
</@c.page>
