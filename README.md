Pour utiliser ce repository en tant que module, il suffit d'ajouter les lignes suivantes dans le `pom.xml` d'un projet :

```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>

...

<dependencies>
    ...
    <dependency>
        <groupId>com.github.Lxsvn98</groupId>
        <artifactId>prisoners-dilemma-shared-strategy</artifactId>
        <version>1.0.4</version>
    </dependency>
    ...
</dependencies>
```

Voici également un exemple d'une stratégie se basant sur l'interface proposée par ce module :

```java
package fr.uga.miage.m1.sharedstrategy;

final class SomeStrategy implements IStrategy {
    @Override
    public String getUniqueId() {
        return "SOME_ID";
    }

    @Override
    public String getFullName() {
        return "Exemple";
    }

    @Override
    public StrategyChoice execute(StrategyExecutionData strategyExecutionData) {
        // Comportement d'exécution de la stratégie...
        return StrategyChoice.COOPERATE;
    }
}
```