<#import "macro/common.ftl" as c>

<@c.page>
<div>
    <form method="post">
        <input type="text" name="application" placeholder="Введите сообщение"/>
        <input type="text" name="applicationStatus" placeholder="Статус заявки"/>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button type="submit">Добавить</button>
    </form>
</div>
<#list messages?ifExists as message>
<div>
    <b>${message.id}</b>
    <span>${message.application}</span>
    <i>${message.applicationStatus}</i>
    <strong>${message.authorName}</strong>
</div>
<#else>
No message
</#list>
</@c.page>