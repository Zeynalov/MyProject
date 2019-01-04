<#import "macro/common.ftl" as c>

<@c.page>
<div class="mb-5">
    <form method="post">
        <input type="text" name="application" placeholder="Введите сообщение"/>
        <input type="text" name="applicationStatus" placeholder="Статус заявки"/>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button type="submit">Добавить</button>
    </form>
</div>
    <#list messages?ifExists as message>
<table class="table">
    <thead class="thead-light">
        <tr>
            <th scope="col">Id</th>
            <th scope="col">Order</th>
            <th scope="col">Status</th>
            <th scope="col">OrderStatus</th>
            <th scope="col">Author</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <th scope="row">${message.id}</th>
            <td>${message.application}</td>
            <td>${message.applicationStatus}</td>
            <td><#list message.orderStatus as order>${order}</#list></td>
            <td>${message.authorName}</td>
        </tr>
    </tbody>
</table>
    <#else>
No message
    </#list>
</@c.page>