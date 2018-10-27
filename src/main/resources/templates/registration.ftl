<#import "macro/common.ftl" as c>
<#import "macro/login.ftl" as l>

<@c.page>
<div class="mb-1">Add new user</div>
${message?ifExists}
<@l.login "/registration" true />
</@c.page>

